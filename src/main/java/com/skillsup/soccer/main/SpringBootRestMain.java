package com.skillsup.soccer.main;

/**
 * Hello world!
 *
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.skillsup.soccer")
@EnableJpaRepositories(basePackages = "com.skillsup.soccer.db")
@EntityScan(basePackages = "com.skillsup.soccer.db.entity")
public class SpringBootRestMain {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestMain.class);
    }
}
