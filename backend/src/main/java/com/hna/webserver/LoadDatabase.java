package com.hna.webserver;

import com.hna.webserver.model.User;
import com.hna.webserver.repository.UserRepository;
import com.hna.webserver.repository.CharbyRepository;
import com.hna.webserver.model.Charby;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, CharbyRepository charbyRepository) {
        return args -> {
            log.info("Preloading " + userRepository.save(new User("Bilbo Baggins")));
            log.info("Preloading " + userRepository.save(new User("Frodo Baggins")));
            log.info("Preloading " + charbyRepository.save(new Charby("Charby 1")));
        };
    }
}
