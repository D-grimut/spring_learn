package spring_security.ch2_ss_notes.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

    // To customize the handling of authentication and authorization -> need to define a bean of type SecurityFilterChain!!!

    @Bean
    // to ovewrwrite a configuration of the security chain in spring, simply make a bean of the config you want to modify!
    // be careful that some configs are interdependant -> when you overwrite one, you may need to overwrite another.
    // this is the case with UserDetailsService and PasswordEncoder
    SecurityFilterChain configure(HttpSecurity http) throws Exception {

        // App will use HTTP Basic auth
        http.httpBasic(Customizer.withDefaults());

        // All requests will require authentication, this is the Default behaviour without any overwritting.
        // http.authorizeHttpRequests(c -> {
        //     c.anyRequest().authenticated();
        // });

        // None of the requests need to be authed.
        http.authorizeHttpRequests(c -> {
            c.anyRequest().permitAll();
        });

        

        return http.build();
    }
}
