package ch3_notes.classes;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch3_notes.config.ContextConfig;
import ch3_notes.config.MultiItemConfig;

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

        System.out.println("------------------ Autowire Constructor param ------------------");

        PersonAutowire pw = context.getBean(PersonAutowire.class);
        ParrotAutowire ppw = context.getBean(ParrotAutowire.class);

        System.out.println("the parrot name is " + ppw.getName());
        // The Parrot() constructor is called only once, when the config loads and we create all the beans, and thats it!
        System.out.println("[Autowired] the parrot that is owned by person bean is " + pw.getParrot()); 
        context.close();

        System.out.println("------------------ MultiItemConfig DI ------------------");

        var context2  = new AnnotationConfigApplicationContext(MultiItemConfig.class);
        Person p = context2.getBean(Person.class);

        System.out.println("[Autowired] the parrot that is owned by person bean is " + p.getParrot().getName()); 
        context2.close();

        /* 
        Summary: 
        Relationships between Beans can be created the following 3 ways: 
            Directly referring to @Bean:    We can directly call the @Bean annotated method from another @Bean method to link two Beans together - Spring knows not to
                                            not to make duplicates and re-use existing Beans in context.

            Defining a parameter to the method annotated with @Bean:    Aka use the name of the @Bean function as the name of the var of the object you want to inject.
                                                                        Spring will seach for objects by this name in its context and inject (not idea approach since func name may change!).

            Using the @Autowired annotation in three ways:
                - Annotate the filed in a class you want spring to inject (not in prod - mostly for PoC).
                - Annotate Constructors for which youd like Spring to inject some arguments.
                - Annotate the setters where you want spring to inject stuff - this can also work for normal methods, but the methods will be called when spring context is created!
            
        
        General notes/caveats:
            - Make sure no circular dependencies exist - Spring will freak out and crash.
            - For @Autowired, in the event of multiple Beans, use @Qualifier to specify the name of the @Bean you want to use, otherwise Spring will try to use the @Primary Bean (if one exists) - otherwise crash!
            - In the event you are trying to break the code and make Beans using @Bean and also using @Component (i.e. 3 objects of the same type but 1 is @Component) - Spring will refer to the component one as the name of the class, with the first letter lowecased!
        */
    }
}
