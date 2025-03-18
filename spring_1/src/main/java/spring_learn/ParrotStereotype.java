package spring_learn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// With stereotype annotations, we are adding the annotation above the class, marking it as a component.
// Note that we can use @Bean and other anotation techniques together.
@Component // This means we can only have one instance of thus class in the context - and can only acess it in the context after Sring creates it +  can only use annotation on classes I own/define (i.e. can't do this for String or Integer)
public class ParrotStereotype {
    
    private String name;

    // I use @Value(...) here to let Spring inject a default value for the constructor to be satisfied.
    // otherwise we get error saying that Bean cannot be created since it's constructor is expeting a value.
    public ParrotStereotype(@Value("hehe") String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
}
