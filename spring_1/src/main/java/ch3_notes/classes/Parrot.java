package ch3_notes.classes;

public class Parrot {
    private String name;


    public Parrot(String name){
        System.out.println("Called Constructor for parrot named " + name);
        this.name = name;   
    }

    public String getName(){
        return name;
    }
}
