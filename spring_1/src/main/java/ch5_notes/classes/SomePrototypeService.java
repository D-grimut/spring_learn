package ch5_notes.classes;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/*
* Prototype Scope is a way of creating unique Beans on demand of the same type, while using a single @Bean function or @Component class.
* The idea is that the every time you request a reference to a prototype-scoped bean, Spring creates a new object instance. 
* Spring manages the object’s type and creates a new instance every time someone requests a reference to the bean - The beans are all unique, so we no
* longer have concurency issues!

* Caveat: The created instances are PARTIALLY managed by the spring context. Meaning, on creation, Spring takes care of them, injecting dependencies and 
* calling stuff like @PostConstruct, but after that the instances are on their own. Spring no longer manages those instances!
*/
@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class SomePrototypeService {
    
}
