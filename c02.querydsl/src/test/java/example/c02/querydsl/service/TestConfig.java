package example.c02.querydsl.service;

import example.c02.querydsl.C02App;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.springframework.context.annotation.ComponentScan.*;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "example.c02")
@EntityScan(basePackages = "example.c02")
@ComponentScan(excludeFilters = {@Filter(type = ASSIGNABLE_TYPE, value = C02App.class)})
public class TestConfig {
}
