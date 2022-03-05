package example.c04.manyToOne.base.service;

import example.c04.manyToOne.base.C04BaseApp;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.springframework.context.annotation.ComponentScan.Filter;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "example.c04")
@EntityScan(basePackages = "example.c04")
@ComponentScan(excludeFilters = {@Filter(type = ASSIGNABLE_TYPE, value = C04BaseApp.class)})
public class TestConfig {
}
