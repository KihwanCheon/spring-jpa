package c08.querydsl.service;


import c08.querydsl.C08QuerydslApp;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.springframework.context.annotation.ComponentScan.Filter;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;


@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "c08")
@EntityScan(basePackages = "c08")
@ComponentScan(excludeFilters = {@Filter(type = ASSIGNABLE_TYPE, value = C08QuerydslApp.class)})
public class TestConfig {
}
