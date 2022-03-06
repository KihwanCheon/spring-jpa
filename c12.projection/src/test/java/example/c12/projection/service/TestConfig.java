package example.c12.projection.service;

import example.c12.projection.C12ProjectionApp;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.springframework.context.annotation.ComponentScan.Filter;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "example.c12")
@EntityScan(basePackages = "example.c12")
@ComponentScan(excludeFilters = {@Filter(type = ASSIGNABLE_TYPE, value = C12ProjectionApp.class)})
public class TestConfig {
}
