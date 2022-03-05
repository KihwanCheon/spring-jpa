package c07.solved.service;

import c07.solved.C07SolvedApp;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.springframework.context.annotation.ComponentScan.Filter;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "c07")
@EntityScan(basePackages = "c07")
@ComponentScan(excludeFilters = {@Filter(type = ASSIGNABLE_TYPE, value = C07SolvedApp.class)})
public class TestConfig {
}
