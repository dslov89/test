package com.umc.mwomeokji.acceptance;

import com.google.common.base.CaseFormat;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class DatabaseCleaner implements InitializingBean {

    @PersistenceContext
    private EntityManager entityManager;

    private List<String> tableNames;

    @Override
    public void afterPropertiesSet() {
        // InitializingBean 인터페이스의 메소드를 구현하는 방법. Spring 에 모든 Bean 들이 등록된 후 해당 메소드가 실행됨
        // 엔티티를 돌며 데이터베이스에서 테이블의 이름을 추출한 tableNames 를 만듦
        tableNames = entityManager.getMetamodel().getEntities().stream()
                .filter(entityType -> Objects.nonNull(entityType.getJavaType().getAnnotation(Entity.class)))
                .map(entityType -> CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, entityType.getName()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void cleanUp() {
        // 쓰기 지연 저장소에 남은 SQL 을 마저 수행
        entityManager.flush();
        // 연관 관계 매핑이 된 테이블일 경우에는 Foreign key 참조 무결성을 해제해야 TRUNCATE 를 할 수 있다.
        entityManager.createNativeQuery(" SET REFERENTIAL_INTEGRITY FALSE;").executeUpdate();
        // 테이블 이름을 순회하며 TRUNCATE 수행, ID 값은 1부터 시작할 수 있도록 테이블 수정
        tableNames.forEach(
                tableName -> executeQueryWithTable(tableName)
        );
        // 해제 해주었던 참조 무결성 설정을 다시 켜기
        entityManager.createNativeQuery(" SET REFERENTIAL_INTEGRITY TRUE;").executeUpdate();
    }

    private void executeQueryWithTable(String tableName) {
        entityManager.createNativeQuery("TRUNCATE TABLE " + tableName + ";").executeUpdate();
        entityManager.createNativeQuery("ALTER TABLE " + tableName + " ALTER COLUMN ID RESTART WITH 1;").executeUpdate();
    }
}
