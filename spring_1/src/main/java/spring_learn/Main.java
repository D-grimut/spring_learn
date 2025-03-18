package spring_learn;

import java.util.function.Supplier;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ProjectConfig;
import config.StereotypeProjectConfig;

public class Main {
    public static void main(String[] args) {

        // the Spring context manages configs, and objects (beans) - this is core idea of IoC. Pass the config class (using .class for Spring to understand the metadata of the class)
        // var (introduced in JDK 10 in 2018) is a way to creteate a variable withotu specifying its type, relying on type inference
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        System.out.println("------------------ Beans ------------------");
        // we need to use the annotation method (since we have an Annotation Context duh), to add parrot object to the context - spring can only manage the 
        // objects it can see inside its context.
        Parrot p = new Parrot("gosha"); // normal obj - not in Context
    
        Parrot context_parrot = context.getBean("parrot", Parrot.class); // referance to Bean obj - in Context

        // some more beans - in context
        String context_str = context.getBean(String.class);
        int ctxt_num = context.getBean(Integer.class);
        boolean ctxt_bool = context.getBean(Boolean.class);

        System.out.println(context_parrot.getName());
        System.out.println(context_str);
        System.out.println(ctxt_num);
        System.out.println(ctxt_bool);

        // ------- Many Beans of the same type -----
        System.out.println("------------------ Many Beans of the same type ------------------");
        // We want to have many parrots, we can register all of them in the context and access the specific one using an idetifier - by default the ID is the name of the method that creates the Bean
        Parrot primary_parrot= context.getBean(Parrot.class); // would throw an error since we have multiple Parrot instances registered in the context - unless we have a Primary Bean
        System.out.println("Primary Bean: " + primary_parrot.getName());
        Parrot ctxt_parrot2 = context.getBean("parrot2", Parrot.class); // acessing the specific parrot using "parrot2" - the name of the method that created the "parrot2" instance
        System.out.println(ctxt_parrot2.getName());

        Parrot ctxt_parrot3 = context.getBean("Duke", Parrot.class);
        System.out.println(ctxt_parrot3.getName());
        context.close();

        System.out.println("------------------ Stereotype Annotation ------------------");
        var context_stereotype = new AnnotationConfigApplicationContext(StereotypeProjectConfig.class);
        ParrotStereotype stereo_parot = context_stereotype.getBean(ParrotStereotype.class);
        System.out.println(stereo_parot.getName()); // null because parrot name not initialized when it was added to spring context!
        context_stereotype.close();

        System.out.println("------------------ Programmatic Context Addition ------------------");
        // In some cases we may want to control the registration of beans such that, depending on specific conditions for instance, a different bean is created and added to the context.
        // To achieve this fine-grained level of control, we can add the beans Programmaticaly (very epic).

        // We need to use registerBean() method, which takes 4 paramters (varagrs BeanDefinitionCustomizer can be ommited if we don't need to configure different characteristics of the bean): String beanName, Class<T> beanClass, Supplier<T> supplier, BeanDefinitionCustomizer... customizers
        var context_prog = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot six_fig_tech_job = new Parrot("Daniel is an epic software dev");

        // Suplier is an object that has one job: take a lambda function that suplies some value
        // This is a Java thing (not from Spring), that allows for lazy evaluation (i.e. give me the value only when I need it, not earlier than that). 
        Supplier<Parrot> sup = () -> six_fig_tech_job;
        context_prog.registerBean("epic parrot", Parrot.class, sup);

        // context_prog.registerBean("epic parrot", Parrot.class, sup, bc -> bc.setPrimary(true)); // adding more varargs to make the Bean primary

        Parrot s = context_prog.getBean("epic parrot", Parrot.class);
        System.out.println(s.getName()); // null because parrot name not initialized when it was added to spring context!
        context_prog.close();

        /* 
        Summary: 
        The Spring context is like a bucket - we add into it stuff we want spring to manage for us. Spring is ONLY aware of the stuff inside its context.
        Beans can be created in 3 ways: 
            Using @Bean:    Can add any type of object to the spring context as a bean, even multiple instances of the same object - very flexible but can be 
                            cumbersome since we need to write a function for each Bean we want to add.\

            Using Stereotype annotations: uses the @Component Annotations in conjustction with a @Configuration (don't forget to add @ComponentScan(basePackages = "package with compononent")!)
                             - more flexible since we can write one class and thats it, but restricts us to using only the classes we own.

            Programmatically: allows us to define our own custom logic to registering the beans, this is highly flexible but also higly situational (also only in Spring 5 and later)
        */
    }
}