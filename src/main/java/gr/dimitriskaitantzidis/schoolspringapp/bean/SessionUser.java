package gr.dimitriskaitantzidis.schoolspringapp.bean;

import gr.dimitriskaitantzidis.schoolspringapp.dao.IUserDAO;
import gr.dimitriskaitantzidis.schoolspringapp.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Optional;

@Component
@SessionScope
public class SessionUser {

    private final IUserDAO userDAO;

    private String email;

    public SessionUser(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @PostConstruct
    public void init() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            this.email = auth.getName(); // user email
        }
    }

    public Integer getUserId() {

        Optional<User> userOptional = userDAO.getUserByEmail(email);

        if (userOptional.isEmpty()) {
            // todo
        }
        return userOptional.get().getId();
    }
}