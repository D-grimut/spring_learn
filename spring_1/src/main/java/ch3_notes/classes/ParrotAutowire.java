package ch3_notes.classes;

import org.springframework.stereotype.Component;

@Component
public class ParrotAutowire {
    private String name;

    public ParrotAutowire(){
        System.out.println("Called Constructor for parrot autowired named " + "Autowired Parrot");
        this.name = "Autowired Parrot";   
    }

    public String getName(){
        return name;
    }
}
