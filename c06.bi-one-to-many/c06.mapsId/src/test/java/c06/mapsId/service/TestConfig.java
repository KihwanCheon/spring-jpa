package c06.mapsId.service;

import c06.mapsId.C06MapsIdApp;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.springframework.context.annotation.ComponentScan.Filter;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "c06")
@EntityScan(basePackages = "c06")
@ComponentScan(excludeFilters = {@Filter(type = ASSIGNABLE_TYPE, value = C06MapsIdApp.class)})
public class TestConfig {
}
