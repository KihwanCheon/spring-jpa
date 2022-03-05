package example.c04.cascade.service;

import example.c04.cascade.C04CascadeApp;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.springframework.context.annotation.ComponentScan.Filter;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "example.c04")
@EntityScan(basePackages = "example.c04")
@ComponentScan(excludeFilters = {@Filter(type = ASSIGNABLE_TYPE, value = C04CascadeApp.class)})
public class TestConfig {
}
