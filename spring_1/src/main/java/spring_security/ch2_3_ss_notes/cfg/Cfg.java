package spring_security.ch2_3_ss_notes.cfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import ch5_notes.config.ProjectCfg;
import spring_security.ch2_3_ss_notes.CustomAuthProvider;

@Configuration
public class Cfg {

    private final CustomAuthProvider authenticationProvider;

    // We are injecting the new custom auth provider into the cfg.
    public Cfg(CustomAuthProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }
    /*
     * Here we are overwritting the UserDetailService component locally through the security filter chain!
     * This is just another way of modifying those components - the difference is here they are no longer accessible as beans
     * to be injected into some other component in the Spring context - both approaches are good.
     * 
    */
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http.httpBasic(Customizer.withDefaults());

        http.authorizeHttpRequests((c) -> {
            c.anyRequest().authenticated();
        });

        // Notice that I am adding a custom authenticationProvider and also implementing a UserDetailService
        // This will make it so Spring will accept both users, as if one provider fails, Spring will try the next
        // component for authenticating the user -> this is hella ambigous tho, so not a good practice standard!
        // More reason to deligate each the appropriate logic to the appropriate component
        UserDetails user = User.withUsername("marie")
                .password("12345")
                .authorities("read")
                .build();
        
        

        // Create the new UserDetailService
        InMemoryUserDetailsManager userDetailService = new InMemoryUserDetailsManager(user);

        // Set the new UserDetailService, as the one to be used for each HTTP request recieved
        http.userDetailsService(userDetailService);

        // Setting the authentication Provider.
        http.authenticationProvider(authenticationProvider);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
