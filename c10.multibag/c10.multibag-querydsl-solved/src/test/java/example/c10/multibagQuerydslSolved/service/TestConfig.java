package example.c10.multibagQuerydslSolved.service;


import example.c10.multibagQuerydslSolved.C10MultibagQuerydslSolvedApp;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.springframework.context.annotation.ComponentScan.Filter;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;


@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "example.c10")
@EntityScan(basePackages = "example.c10")
@ComponentScan(excludeFilters = {@Filter(type = ASSIGNABLE_TYPE, value = C10MultibagQuerydslSolvedApp.class)})
public class TestConfig {
}
