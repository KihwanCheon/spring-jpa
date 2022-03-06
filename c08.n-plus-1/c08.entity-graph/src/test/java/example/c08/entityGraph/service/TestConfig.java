package example.c08.entityGraph.service;

import example.c08.entityGraph.C08EntityGraphApp;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.springframework.context.annotation.ComponentScan.Filter;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "example.c08")
@EntityScan(basePackages = "example.c08")
@ComponentScan(excludeFilters = {@Filter(type = ASSIGNABLE_TYPE, value = C08EntityGraphApp.class)})
public class TestConfig {
}
