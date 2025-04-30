package gr.dimitriskaitantzidis.schoolspringapp.controller;

import gr.dimitriskaitantzidis.schoolspringapp.service.ITeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@RequestMapping("/teachers")
@Controller
public class TeachersController {

    private final ITeacherService teacherService;

    public TeachersController(ITeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping({ "", "/index", "/index.html"})
    public String listTeachersOrderByLnameFname(Model model) throws SQLException {

        model.addAttribute("teachers", teacherService.getAllTeachersOrderByLnameFname());

        return "teachers/index";
    }
}
