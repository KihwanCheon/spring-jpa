package example.c07.quest.service;

import example.c07.quest.C07QuestApp;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.springframework.context.annotation.ComponentScan.Filter;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "example.c07")
@EntityScan(basePackages = "example.c07")
@ComponentScan(excludeFilters = {@Filter(type = ASSIGNABLE_TYPE, value = C07QuestApp.class)})
public class TestConfig {
}
