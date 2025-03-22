package ch3_notes.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonAutowire {
    
    // We could just add @Autowired here and Spring will assing a Parrot component from it's context to the var pet.
    // However, this is not good practice, since we cannot make the var final as it expects a value at initialization. 
    final private ParrotAutowire pet;
    private ParrotAutowire pet2;

    @Autowired 
    // by adding @Autowired, Spring knows to use the Parrot instance in its context and assign it here
    // if we have many Parrot instances (ex we have many @Bean that cretes Parrots), then Spring selectes the primary instance
    PersonAutowire(ParrotAutowire pet){
        this.pet = pet;
    }
    
    // @Autowired
    // Note: in the event of ONE ParrotAutowire instance in context, Spring injects the same value for both arguments here - for multiple instances see the other examples :) (spoilers: Spring can handle it!)
    // PersonAutowire(ParrotAutowire pet, ParrotAutowire p2){
    //     this.pet = pet;
    //     this.p2 = p2;
    // }

    // It is also possible to Autowire inside setters (not recommended to do)
    @Autowired
    public void setParrot(ParrotAutowire parrot) {
        System.out.println("Called set p2");
        this.pet2 = parrot;
    }

    // Different method signatures can be autowired too - in this case both are called.
    @Autowired
    public void setParrot(ParrotAutowire parrot, Parrot p) {
        System.out.println("Called set (diff signature)");
        this.pet2 = null;
    }


    // Note: If one of the parameters does not exist in the context, Spring will crash if that entity is required in an Autowired function.
    // @Autowired
    // public void setParrot(ParrotAutowire parrot, int x) {
    //     System.out.println("Called set (this should not print)");
    //     this.pet2 = null;
    // }

    public ParrotAutowire getParrot(){
        return this.pet;
    }

    public ParrotAutowire getParrot2(){
        return this.pet2;
    }

    // Autowired can be used for random functions like this one too - for DI of Beans
    // @Autowired
    // public int returnInt(Parrot p){
    //     System.out.println("random autowired func");
    //     return 3;
    // }
}
