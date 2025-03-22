package ch3_notes.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// We have a Circular Dependency in this class - to create PersonDeadlock, we need an instance of ParrotDeadlock, but ParrotDeadlock needs a PersonDealock to construct!
// The only way out of this is to hire Daniel, and ask him kindly, bribing with coffee and snacks to rewrite the code to eliminate the circular dependency ;)
@Component
public class PersonDeadlock {

    // Commented out since the circular dependency crashes Spring.
    // final private ParrotDeadlock pet;

    // @Autowired 
    // PersonDeadlock(ParrotDeadlock pet){
    //     this.pet = pet;
    // }

    // public ParrotDeadlock getPet(){
    //     return this.pet;
    // }
}
