package example.c09.methodNamingQuest.service;

import example.c09.methodNamingQuest.C09NamingMethodQuestApp;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.springframework.context.annotation.ComponentScan.Filter;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "example.c09")
@EntityScan(basePackages = "example.c09")
@ComponentScan(excludeFilters = {@Filter(type = ASSIGNABLE_TYPE, value = C09NamingMethodQuestApp.class)})
public class TestConfig {
}
