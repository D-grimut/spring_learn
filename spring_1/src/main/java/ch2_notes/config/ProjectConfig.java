package ch2_notes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import ch2_notes.spring_learn.Parrot;

// @Bean = manualy constructing an object for Spring to manage
// @Component = dynamic way of defining an object for Spring to track in its context and manage

// Configuration class is a special type of class that instructs Spring on different actions (more on this later)
@Configuration
public class ProjectConfig{

    // Tells Spring to call this method when context is intialised and add the returned object into the context
    // note: the convention in Spring is to name the Bean method as the object that is returned to the context (no verbs)
    @Bean
    @Primary // this defines a Primary bean (resolves ambiguity) - bean that is returned if we refer in the context only by the object type and have multiple objects of the same type
    Parrot parrot(){
        return new Parrot("Artyom");
    }

    // We can define multiple objects of the same type with @Bean by simply naming the "creation" method differently
    @Bean
    Parrot parrot2() {
        return new Parrot("Miller");
    }

    // This is a way to overrite the default name of Bean (which is the name of the method)
    // other valid ways are:
    // @Bean(value = "Duke")
    // @Bean("Duke")
    @Bean (name = "Duke")
    Parrot parrot3() {
        return new Parrot("Duke");
    }

    // anything can be a Bean - including primitieves and String - but for convention sake, keep at objects (so use Wrappers)
    @Bean()
    String hello(){
        return "now this is epic";
    }

    @Bean
    Integer num(){
        return 420;
    }

    @Bean
    Boolean bool(){
        return true;
    }
}