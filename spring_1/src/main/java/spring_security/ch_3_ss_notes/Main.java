package spring_security.ch_3_ss_notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        // Another way to create an immutable instance of UserDetails is by using the User Builder:
        // UserDetails u = User.withUsername("bill")
        //                 .password("12345")
        //                 .authorities("read", "write")
        //                 .accountExpired(false)
        //                 .disabled(true)
        //                 .build();
                        
        SpringApplication.run(Main.class, args);
    }
}
