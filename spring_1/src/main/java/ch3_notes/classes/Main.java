package ch3_notes.classes;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch3_notes.config.ContextConfig;

public class Main {
    public static void main(String[] args) {
        var context  = new AnnotationConfigApplicationContext(ContextConfig.class);
        Person pNoArgs = context.getBean("personNoArgs", Person.class);
        Person pArgs = context.getBean("personArgs", Person.class);
        Parrot pp = context.getBean(Parrot.class);

        System.out.println("the parrot name is " + pp.getName());
        // The Parrot() constructor is called only once, when the config loads and we create all the beans, and thats it!
        System.out.println("[parrot() method called] the parrot that is owned by person bean is " + pNoArgs.getParrot()); 
        System.out.println("[Parrot passed as argument in config] the parrot that is owned by person bean is " + pArgs.getParrot());
        context.close();
    }
}
