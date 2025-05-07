package gr.dimitriskaitantzidis.schoolspringapp.controller;

import gr.dimitriskaitantzidis.schoolspringapp.dao.ITeacherDAO;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@RequestMapping("/teacher")
@Controller
public class TeacherController {

    private final ITeacherDAO teacherDAO;

    public TeacherController(ITeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Secured("ROLE_TEACHER")
    @RequestMapping({"", "/index", "/index.html"})
    public String listTeachersOrderByLnameFname(Model model) throws SQLException {

        model.addAttribute("teachers", teacherDAO.getAllTeachersOrderByLnameFname());

        return "teacher/index";
    }
}
