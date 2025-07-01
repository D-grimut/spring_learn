package ch5_notes.classes;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch4_notes.model.Comment;
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


        // ----------------- No Race Condition (Good) Scope Example -----------------
        // See SomePrototypeService for explanation
        CommentService cs = c.getBean(CommentService.class);
        Thread t1 = new Thread(() ->{
            cs.sendComment(new Comment("Wise Daniel", "anything you ever wanted is on the other side of fear"), 0);
        });

        Thread t2 = new Thread(() ->{
            cs.sendComment(new Comment("A wise man", "let discipline dictate your life, but don't only do boring things either"), 1);
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Both threads finished.");

        System.out.println("------------------------------------");

        // ----------------- Race Condition (Bad) Scope Example -----------------
        // In this example we can see how the the comment created by thread 1 is overwritten by thread 2 after they execute - meaning that the same CommentRepository instance was used! Race condition!
        CommentServiceRaceConditions cs_bad = c.getBean(CommentServiceRaceConditions.class);
        Thread t1_bad = new Thread(() ->{
            cs_bad.sendComment(new Comment("Unwise Daniel", "don't take a risk, and always take the safe path"), 0);
        });

        Thread t2_bad = new Thread(() ->{
            cs_bad.sendComment(new Comment("An unwise man", "let your impulses control you, and indulge in your vices"), 1);
        });

        t1_bad.start();
        t2_bad.start();

        c.close();
    }
}
