package com.umc.mwomeokji;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@Profile("local")
@RequiredArgsConstructor
public class LocalDataController {

    private final DataLoader dataLoader;

    @Operation(summary = "데이터 초기화 API", description = "로컬 테스트환경에서 데이터베이스를 초기화하기 위한 API 입니다.")
    @GetMapping("/data/setting")
    public ResponseEntity<String> dataSetting() {
        dataLoader.loadData();
        return ResponseEntity.status(OK).body("데이터가 성공적으로 초기화되었습니다.");
    }
}
