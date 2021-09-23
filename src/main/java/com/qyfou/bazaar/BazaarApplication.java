package com.qyfou.bazaar;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

/*开启jpa审计*/
@EnableJpaAuditing
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@EnableScheduling
@SpringBootApplication
@MapperScan(basePackages = "com.qyfou.bazaar.dao")
public class BazaarApplication {

    public static void main(String[] args) {
        SpringApplication.run(BazaarApplication.class, args);
    }

}
