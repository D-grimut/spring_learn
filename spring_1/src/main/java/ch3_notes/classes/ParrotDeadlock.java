package ch3_notes.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParrotDeadlock {
    private String name;
    private PersonDeadlock owner;

    // @Autowired
    // public ParrotDeadlock(PersonDeadlock owner){
    //     this.owner = owner;
    //     this.name = "Deadlock Parrot";   
    //     System.out.println("Called Constructor for parrot DEADLOCK named " + this.name);
    // }

    // public String getName(){
    //     return this.name;
    // }

    // public PersonDeadlock getOwner(){
    //     return this.owner;
    // }
}
