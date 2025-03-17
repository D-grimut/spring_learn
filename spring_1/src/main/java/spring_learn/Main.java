package spring_learn;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ProjectConfig;

public class Main {
    public static void main(String[] args) {

        // the Spring context manages configs, and objects (beans) - this is core idea of IoC. Pass the config class (using .class for Spring to understand the metadata of the class)
        // var (introduced in JDK 10 in 2018) is a way to creteate a variable withotu specifying its type, relying on type inference
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

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
        // We want to have many parrots, we can register all of them in the context and access the specific one using an idetifier - by default the ID is the name of the method that creates the Bean
        Parrot primary_parrot= context.getBean(Parrot.class); // would throw an error since we have multiple Parrot instances registered in the context - unless we have a Primary Bean
        System.out.println("Primary Bean: " + primary_parrot.getName());
        Parrot ctxt_parrot2 = context.getBean("parrot2", Parrot.class); // acessing the specific parrot using "parrot2" - the name of the method that created the "parrot2" instance
        System.out.println(ctxt_parrot2.getName());

        Parrot ctxt_parrot3 = context.getBean("Duke", Parrot.class);
        System.out.println(ctxt_parrot3.getName());
    }
}