package c05.base.service;

import c05.base.C05BaseApp;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.springframework.context.annotation.ComponentScan.Filter;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "c05")
@EntityScan(basePackages = "c05")
@ComponentScan(excludeFilters = {@Filter(type = ASSIGNABLE_TYPE, value = C05BaseApp.class)})
public class TestConfig {
}
