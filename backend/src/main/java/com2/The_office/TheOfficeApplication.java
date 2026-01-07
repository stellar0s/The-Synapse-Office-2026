package com2.The_office;   // <-- package names must always be lowercase!

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling  // Enables scheduled tasks (for auto-save, background jobs, etc.)
public class TheOfficeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TheOfficeApplication.class, args);
        System.out.println("✅ The Office Application started with Scheduling enabled.");
    }

}
