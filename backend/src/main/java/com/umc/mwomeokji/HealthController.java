package com.umc.mwomeokji;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HealthController {

    @GetMapping("/api/health")
    public String healthCheck() {
        return "OK!";
    }
}
