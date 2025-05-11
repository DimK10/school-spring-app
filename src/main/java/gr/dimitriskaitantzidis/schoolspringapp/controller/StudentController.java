package gr.dimitriskaitantzidis.schoolspringapp.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;


@RequestMapping("/student")
@Controller
public class StudentController {

    public StudentController() {
    }

    @Secured("ROLE_STUDENT")
    @RequestMapping({ "", "/index", "/index.html"})
    public String index(Model model) throws SQLException {
        return "student/index";
    }
}
