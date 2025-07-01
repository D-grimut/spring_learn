package ch5_notes.classes;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/*
 * In Spring, by default beans are all created and loaded into the context when the cfg is initilized.
 * This means, all beans are created before we even think of needing them, this is Eager Initialization.
 * 
 * We can offset this behaviour and force Spring to only create a Bean when we need it for the first time.
 * This is done by annotating the Bean or Component with @Lazy, forcing Spring to delay Bean creation until later.
 * This is Lazy Initialization.
 * Usefull when loading all components at once can make the app slow, or when some 
 * components are never used, and we want to save on resources by never loading the components into the context.
 * 
 * Lazy intialization has the disadvantage of crashing the program during runtime (much later after it was started) in the events the Bean cannot be created.
 * Also, Lazy initialisation forces the Spring to check if the bean exist before creating it in context, which is less performant than creating the bean right away.
*/

@Lazy
@Service
public class SomeLazyService {

    public SomeLazyService() {
        System.out.println("SomeService instance created.");
    }

}
