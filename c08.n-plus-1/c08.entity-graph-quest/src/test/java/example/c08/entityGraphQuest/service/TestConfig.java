package example.c08.entityGraphQuest.service;

import example.c08.entityGraphQuest.C06EntityGraphQuestApp;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.springframework.context.annotation.ComponentScan.Filter;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "example.c05")
@EntityScan(basePackages = "example.c05")
@ComponentScan(excludeFilters = {@Filter(type = ASSIGNABLE_TYPE, value = C06EntityGraphQuestApp.class)})
public class TestConfig {
}
