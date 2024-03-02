package com.springsecurityjwt;

import com.springsecurityjwt.enums.ERole;
import com.springsecurityjwt.entities.RoleEntity;
import com.springsecurityjwt.entities.UserEntity;
import com.springsecurityjwt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class SpringSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtApplication.class, args);
    }

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Bean
    CommandLineRunner init() {
        return args -> {

            UserEntity userEntityAdmin = UserEntity
                    .builder()
                    .email("aramberrylucas@admin.com")
                    .username("admin")
                    .password(new BCryptPasswordEncoder().encode("lucas"))
                    .roles(Set.of(RoleEntity
                            .builder()
                            .name(ERole.valueOf(ERole.ADMIN.name()))
                            .build()))
                    .build();

            UserEntity userEntityUser = UserEntity
                    .builder()
                    .email("aramberrylucas@user.com")
                    .username("user")
                    .password(new BCryptPasswordEncoder().encode("lucas"))
                    .roles(Set.of(RoleEntity
                            .builder()
                            .name(ERole.valueOf(ERole.USER.name()))
                            .build()))
                    .build();

            UserEntity userEntityInvited = UserEntity
                    .builder()
                    .email("aramberrylucas@invited.com")
                    .username("invited")
                    .password(new BCryptPasswordEncoder().encode("lucas"))
                    .roles(Set.of(RoleEntity
                            .builder()
                            .name(ERole.valueOf(ERole.INVITED.name()))
                            .build()))
                    .build();

            userRepository.save(userEntityAdmin);
            userRepository.save(userEntityUser);
            userRepository.save(userEntityInvited);

        };
    }
}
