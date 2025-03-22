package ch3_notes.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ch3_notes.classes.Parrot;
import ch3_notes.classes.Person;

@Configuration
@ComponentScan(basePackages = "ch3_notes.classes")
public class MultiItemConfig {

    @Bean
    public Parrot p1(){
        Parrot p = new Parrot("Cigartette");
        return p;
    }

    @Bean
    public Parrot p2(){
        Parrot p = new Parrot("DC");
        return p;
    }

    // @Bean
    // // Spring will freak out here! there are many Beans in context, so Spring does not know which ones to use.
    // // One way to resolve this ambiguity, is by having a @Primary Bean - this will take prescedance over all Other beans however!
    // // a better approach is using the name of the Bean "function", as the name of the parameter that we wish to inject
    // // the Bean function name is the litera; "ID" of that Bean inside Spring context!

    // // This whould work in theory, but requires compiling Spring using '-parameters', which is cumbersomes
    // public Person person(Parrot p2){
    //     Person pers = new Person(p2);
    //     System.out.println("[Spring DI] Person called with Parrot : " + p2.getName());
    //     return pers;
    // }

    @Bean
    // A better approach, is using the @Qualifier to refer to the ID (func name) of the object within the Spring context to use.
    // This annotation (including the approach ontop) work for both Bean and Components - so we can avoid using Autowired and use Qualifier instead (only for functions! vars we would need to use both Autowired and Qualifier)
    public Person person(@Qualifier("p2") Parrot parrot){
        Person pers = new Person(parrot);
        System.out.println("[Spring DI] Person called with Parrot : " + parrot.getName());
        return pers;
    }

    
}
