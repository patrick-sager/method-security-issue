package com.example.methodsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringBootMain {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootMain.class, args);
  }

}
