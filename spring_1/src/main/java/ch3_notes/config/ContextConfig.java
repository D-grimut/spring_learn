package ch3_notes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ch3_notes.classes.Parrot;
import ch3_notes.classes.Person;

@Configuration
@ComponentScan(basePackages = "ch3_notes.classes")
public class ContextConfig {
    
    @Bean
    public Parrot parrot(){
        Parrot p = new Parrot("patchy");
        return p;
    }

    @Bean
    // adding Parrot to Person by calling the Bean method for Parrot
    public Person personNoArgs(){
        Person pers = new Person(parrot()); // spring is smart enough to know to create a Parrot instance (and add to context) OR to get the existing one from the context - no duplicates yippiee
        return pers;
    }

    @Bean
    // adding Parrot to Person by passing a Parrot instance as an argument.
    // Spring knows to use the Parrot bean in context, or create the Parrot Bean 
    // be that created using @Bean or @Component - important that some Parrot instance exists in the context.
    // this here is an instance of dependency injection and IoC!!!
    public Person personArgs(Parrot p){
        Person pers = new Person(p); // spring is smart enough to know to create a Parrot instance (and add to context) OR to get the existing one from the context - no duplicates yippiee
        return pers;
    }
}
