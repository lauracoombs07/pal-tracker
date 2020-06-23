package io.pivotal.pal.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import javax.swing.*;

@SpringBootApplication

public class PalTrackerApplication {
    private TimeEntryRepository TimeEntryRepository;

    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }

    @Bean
    public TimeEntryRepository timeEntryRepository() {
        return new InMemoryTimeEntryRepository();
    }
}
