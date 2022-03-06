package example.c11.paginationQuerydsl.service;

import example.c11.paginationQuerydsl.C11PaginationQuerydslApp;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.springframework.context.annotation.ComponentScan.Filter;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "example.c11")
@EntityScan(basePackages = "example.c11")
@ComponentScan(excludeFilters = {@Filter(type = ASSIGNABLE_TYPE, value = C11PaginationQuerydslApp.class)})
public class TestConfig {
}
