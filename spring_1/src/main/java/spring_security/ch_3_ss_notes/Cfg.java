package spring_security.ch_3_ss_notes;

import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Cfg {
    
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails u1 = new DummyUser("Grifith", "GodComplexhihi", "read");
        UserDetails u2 = new DummyUser("Guts", "Grifithanopp", "read");

        HashMap<String, UserDetails> map = new HashMap<>();
        map.put(u1.getUsername(), u1);
        map.put(u2.getUsername(), u2);

        return new InMemoryUserDetailsService(map);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
