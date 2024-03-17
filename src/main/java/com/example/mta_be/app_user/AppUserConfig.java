package com.example.mta_be.app_user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppUserConfig {
    @Bean
    CommandLineRunner commandLineRunner(AppUserRepository repository){
        return args -> {
            AppUser user1 = new AppUser("mario","123",160.6,70,19,new byte[0]);
            AppUser user2 = new AppUser("alex","234",176.6,75,22,new byte[0]);
            repository.saveAll(
                    List.of(user2, user1)
            );
        };
    }
}
