package com.chocolatecakedonut

import com.chocolatecakedonut.scoreKeeper.service.ScoreService
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

import javax.sql.DataSource

@Configuration
@EnableJpaRepositories
@EntityScan(basePackages = ['com.chocolatecakedonut.scoreKeeper.domain'])
@EnableTransactionManagement
class AppConfig {

    @Bean
    ScoreService scoreService(){
        new ScoreService()
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.prod")
    public DataSource dataSource() {
        def db =  DataSourceBuilder.create().build();

        println "!!!!!!!! " + db.properties

        db
    }




}
