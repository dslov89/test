package com.umc.mwomeokji;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
// @Profile("local")
@RequiredArgsConstructor
public class LocalDataStarter implements ApplicationRunner {

    private final DataLoader dataLoader;

    @Override
    public void run(ApplicationArguments args) {
        dataLoader.loadData();
    }
}
