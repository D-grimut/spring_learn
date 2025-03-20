package ch3_notes.classes;

public class Person {
    private Parrot peter;

    public Person(Parrot p){
        this.peter = p;
    }

    public Parrot getParrot(){
        return this.peter;
    }
}
