package ch2_notes.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Configuration class is a special type of class that instructs Spring on different actions (more on this later)
@Configuration
// ComponentScan tells Spring which packages to scan to find the @Component classes.
@ComponentScan(basePackages = "ch2_notes.spring_learn")
public class StereotypeProjectConfig{
}