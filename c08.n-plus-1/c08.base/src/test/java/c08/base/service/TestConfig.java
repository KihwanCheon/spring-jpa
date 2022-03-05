package c08.base.service;

import c08.base.C08BaseApp;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.springframework.context.annotation.ComponentScan.Filter;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "c08")
@EntityScan(basePackages = "c08")
@ComponentScan(excludeFilters = {@Filter(type = ASSIGNABLE_TYPE, value = C08BaseApp.class)})
public class TestConfig {
}
