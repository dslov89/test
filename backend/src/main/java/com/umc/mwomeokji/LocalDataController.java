package com.umc.mwomeokji;

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

    @GetMapping("/data/setting")
    public ResponseEntity<String> dataSetting() {
        dataLoader.loadData();
        return ResponseEntity.status(OK).body("데이터가 성공적으로 초기화되었습니다.");
    }
}
