package spring_security.ch2_3_ss_notes;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/*
 * Here we are implementing a Custom Authentication Provider.
 * That is, we are defining our own custom authentication logic.
 * After having defined it, we must conenct the new auth provider to the Security Filter Chain
 * which is done by injecting the bean in the congig file and adding it to the filter chain (see the cfg file)
*/
@Component
public class CustomAuthProvider implements AuthenticationProvider{

    /*
     * Here the CustomAuthenticationProvider is implementing the logic of both UserDetailService and the PasswordEncoder.
     * This is not good practice!
     * It is much better to decouple the userretrival and password maching logic and delegate it to the appropriate components instead.
     * This decoupling makes the code less confusing.
    */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = String.valueOf((authentication.getCredentials()));

        if("john".equals(username) && "12345".equals(password)){
            // We are effectively creating a new Authentication Token that represents the given user within the Spring Security Context!
            // This means we could access the user that made the API request anywhere in the code after the user has been authenticated.
            return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());
        }else{
            throw new AuthenticationCredentialsNotFoundException("Error!");
        }
    }

    @Override
    public boolean supports(Class<?> authenticationType) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authenticationType);
    }
    
}
