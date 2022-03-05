package example.c03.challenge.service;

import example.c03.challenge.C03ChallengeApp;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.springframework.context.annotation.ComponentScan.Filter;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "example.c03")
@EntityScan(basePackages = "example.c03")
@ComponentScan(excludeFilters = {@Filter(type = ASSIGNABLE_TYPE, value = C03ChallengeApp.class)})
public class TestConfig {
}
