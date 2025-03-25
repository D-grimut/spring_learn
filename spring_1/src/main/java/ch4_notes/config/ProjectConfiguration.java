package ch4_notes.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"ch4_notes.proxies", "ch4_notes.repos", "ch4_notes.services"})
public class ProjectConfiguration {
    
}
