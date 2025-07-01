package ch5_notes.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"ch5_notes.classes"})
public class ProjectCfg {
    
}
