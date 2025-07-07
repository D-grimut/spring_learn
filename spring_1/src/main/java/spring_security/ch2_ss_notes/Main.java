package spring_security.ch2_ss_notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// this tells Spring Boot that this is the main entry point into the app.
// @SpringBootApplication triggers component scanning starting from its own package downward.
@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        /*
         * Spring Boot (SB), performs a component scan starting from the file annotated with SpringBootApplication
         * follwoing the scan, SB will create a SINGLE application context into which it will merge all Beans and Config files.
         * In the event of Beans with clashing names, in different config files, Spring will throw an error on startup!
         * This is different from Core Spring, which allows creating only one config file per context, and instead
         * allows to create multiple context in a single app run. Preaty cool!
        */

        // this is how spring boot  boots up!.
        // sb requires the class from where the app starts, and spring will take over by scaning all subdirectories
        // to load in all the configs and load the beans into context. 
        SpringApplication.run(Main.class, args);
    }
}
