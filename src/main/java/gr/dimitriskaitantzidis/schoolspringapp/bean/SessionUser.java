package gr.dimitriskaitantzidis.schoolspringapp.bean;

import jakarta.annotation.PostConstruct;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionUser {

    private String email;

    @PostConstruct
    public void init() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            this.email = auth.getName(); // user email
        }
    }

    public Integer getUserId() {
        return null;
    }
}