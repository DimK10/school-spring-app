package gr.dimitriskaitantzidis.schoolspringapp.controller;

import gr.dimitriskaitantzidis.schoolspringapp.bean.SessionUser;
import gr.dimitriskaitantzidis.schoolspringapp.dao.ITeacherDAO;
import gr.dimitriskaitantzidis.schoolspringapp.model.Teacher;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@RequestMapping("/teacher")
@Controller
public class TeacherController {

    private final ITeacherDAO teacherDAO;

    private final SessionUser sessionUser;

    public TeacherController(ITeacherDAO teacherDAO, SessionUser sessionUser) {
        this.teacherDAO = teacherDAO;
        this.sessionUser = sessionUser;
    }

    @Secured("ROLE_TEACHER")
    @RequestMapping({"", "/index", "/index.html"})
    public String listTeachersOrderByLnameFname(Model model) throws SQLException {

        Integer userId = sessionUser.getUserId(); // todo maybe add spring aop with custom annotation to inject the entity using around invoke

        Teacher teacher = teacherDAO.getTeacherById(userId); // todo maybe add spring aop with custom annotation to inject the entity using around invoke

        model.addAttribute("courses", teacherDAO.getAssociatedCourses(teacher));

        return "teacher/index";
    }
}
