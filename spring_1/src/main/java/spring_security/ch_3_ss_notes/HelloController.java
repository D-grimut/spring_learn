package spring_security.ch_3_ss_notes;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {
    
    @GetMapping("/hello")
    public String hello(@AuthenticationPrincipal UserDetails userDetails) {

        return "Hello!" + userDetails.getUsername();
    }
    
}
