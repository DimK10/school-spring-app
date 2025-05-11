package gr.dimitriskaitantzidis.schoolspringapp.controller;

import gr.dimitriskaitantzidis.schoolspringapp.service.exceptions.teacher.TeacherNotFoundException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

import static gr.dimitriskaitantzidis.schoolspringapp.util.Constants.ROLE_ADMIN;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Secured(ROLE_ADMIN)
    @RequestMapping({"", "/index", "/index.html"})
    public String getAssociatedCoursesByTeacher(Model model) throws SQLException, TeacherNotFoundException {


        return "admin/index";
    }
}
