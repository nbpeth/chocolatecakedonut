package com.chocolatecakedonut

import com.chocolatecakedonut.scoreKeeper.service.ScoreService
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories
@EntityScan(basePackages = ['com.chocolatecakedonut.scoreKeeper.domain'])
class AppConfig {

    @Bean
    ScoreService scoreService(){
        new ScoreService()
    }
}
