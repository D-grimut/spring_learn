package ch5_notes.classes;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch4_notes.services.CommentService;
import ch5_notes.config.ProjectCfg;

public class Main {
    public static void main(String[] args) {

        // ----------------- Singleton Scope Explanation -----------------
        /*
            So far we have seen singleton beans. Meaning that in the normal way of defining both component and beans, we are ever only creating
            a single instance of that bean (with some caveats!).

            Caveat: when we use the @Bean annotation to create beans, we are creating pseudo-singleton beans. Meaning, that the specific bean instance
            itself is singleton, and only one such bean can exist, but this does not make the Bean unique to the type. We can have two beans of the same
            type, they are "singelton" in the sense that each bean of specific ID (ID = name of bean method), will exist.

            In the context of stereotype components annotated by @Component (or other tags like @Service), those beans are created into the spring context
            folowing the true singleton design pattern - with @Component only one such bean will ever exist in the spring context.

            Never use singleton beans for multithreading, as this creates a race condition risk. Synchronizing singleton beans will make the program hella slow,
            so do not attempt to do so, rather hire me, Daniel to redesing your app! AVOID MAKING MUTABLE SINGLETON BEANS.
        */

        // ----------------- Lazy Initialization Example -----------------
        // See SomeLazyService for explanation
        var c = new AnnotationConfigApplicationContext(ProjectCfg.class);
        System.out.println("Before retrieving the Lazy Service");
        SomeLazyService service = c.getBean(SomeLazyService.class);
        System.out.println("After retrieving the Lazy Service");

        // ----------------- Prototype Scope Example -----------------
        // See SomePrototypeService for explanation
        var cs1 = c.getBean(SomePrototypeService.class);
        var cs2 = c.getBean(SomePrototypeService.class);
        boolean b1 = cs1 == cs2;
        System.out.println(b1); // is always false

        c.close();
    }
}
