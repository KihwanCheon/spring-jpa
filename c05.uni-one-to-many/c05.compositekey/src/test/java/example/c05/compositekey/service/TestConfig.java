package example.c05.compositekey.service;

import example.c05.compositekey.C05CompositeKeyApp;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.springframework.context.annotation.ComponentScan.Filter;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "example.c05")
@EntityScan(basePackages = "example.c05")
@ComponentScan(excludeFilters = {@Filter(type = ASSIGNABLE_TYPE, value = C05CompositeKeyApp.class)})
public class TestConfig {
}
