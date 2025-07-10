package spring_security.ch_3_ss_notes;

import java.util.HashMap;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

// Recall that the UserDetailsService is the component that is responsible for fetching a user from the DB using their username.
// To implement our own UserDetailsService, we need to implement the loadUserByUsername function from the Interface UserDetailsService.
public class InMemoryUserDetailsService implements UserDetailsService{

    // Since I am too lazy to connect to a real DB (and since I got no clue yet how JPA works)
    // we will use an in memeory list of users.
    private final HashMap<String, UserDetails> users;

    InMemoryUserDetailsService(HashMap<String, UserDetails> users){
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(this.users.containsKey(username)){
            return this.users.get(username);
        }else{
            throw new UsernameNotFoundException("User not found!");
        }
    }
    
}
