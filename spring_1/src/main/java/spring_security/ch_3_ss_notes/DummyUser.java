package spring_security.ch_3_ss_notes;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// This is an example of how to create a custom UserDetail -> to model a user in the Sptring Security context
public class DummyUser implements UserDetails{

    private final String username;
    private final String password;
    private final String authority;

    DummyUser(String username, String password, String authority) {
        this.username = username;
        this.password = password;
        this.authority = authority;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        // GrantedAuthority is an Functional Interface, so we can create an concrete instance of the Interface, by passing a
        // lamnda to the object -> preatty much sayinng "create an object of the interface type, and since you have one unimplemented
        // method, put this as the implementation for it".

        GrantedAuthority g1 = () -> this.authority;

        // Can also make an immuatble GrantedAuthority like this:
        // GrantedAuthority g1 = new SimpleGrantedAuthority("READ");

        return List.of(g1);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
