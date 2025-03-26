package ch4_notes.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch4_notes.config.ProjectConfiguration;
import ch4_notes.model.Comment;
import ch4_notes.services.CommentService;

/* 
General Notes:
    In Spring, especialy spring boot, code usualy follows a MVC structure, where we have Services, repos, proxies and models.
    Proxies = Anything that communicates and establishes communication with the outside world (ex: email notification)
    model = digital representation of some entity we want to mode (ex: a comment)
    repos = anything that connects and interacts with a DB - i.e. Data Access Objects (DAO)
    service = objects that implmenet the buisnes logic/use-cases of our app
*/ 
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        CommentService cs = context.getBean(CommentService.class);
        Comment c = new Comment("Daniel", "Daniel is 1 step closer to being a 10x dev");
        cs.publishComment(c);
        context.close();

        /* 
        Summary:
            - Decoupling is king - abtsracting your code makes it easier to extends in the fucture.
            - Spring works well with abstraction - as seen by the Startegy like design pattern and interfaces.
            - Spring can find beans of a parent/interface type and inject them.
            - Always use Stereotype annotations to concrete classes, never abstract classes or interfaces since an instance of these will not be created by Spring (since we can't instantiate an interface or abst. class duh)
            - When multiple beans of same type in context, we can use the folowing to resolve ambiguity:
                - use @Primary to identify the primary Bean; usualy when you have one implemnetation you want Spring to "default" to
                - use @Qualifier; when we have multiple beans with all valid implementations (finer grained control)
            - Use service components, meaning @Repository and @Service, for DB repo and Service components respectively - leave @Component for generic objects (this improved app readibility)
        */ 
    }
}
