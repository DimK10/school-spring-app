package gr.dimitriskaitantzidis.schoolspringapp.controller;

import gr.dimitriskaitantzidis.schoolspringapp.dto.UserDTO;
import gr.dimitriskaitantzidis.schoolspringapp.service.exceptions.admin.UserNotFoundException;
import gr.dimitriskaitantzidis.schoolspringapp.service.impl.AdminService;
import jakarta.validation.Valid;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;

import static gr.dimitriskaitantzidis.schoolspringapp.util.Constants.ROLE_ADMIN;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @Secured(ROLE_ADMIN)
    @RequestMapping({"", "/index", "/index.html"})
    public String index(Model model) throws SQLException, UserNotFoundException {
        List<UserDTO> userDTOList = adminService.getAllUsersOrderByName();

        model.addAttribute("users", userDTOList);

        return "admin/index";
    }

    @Secured(ROLE_ADMIN)
    @RequestMapping({"/create", "create/index", "create/index.html"})
    public String createUser(Model model) {

        model.addAttribute("userDTO", new UserDTO());

        return "admin/create/index";
    }

    @PostMapping("/create")
    public String handleCreateUser(
            @Valid @ModelAttribute("userDTO") UserDTO userDTO,
            BindingResult bindingResult) throws SQLException {

        if (bindingResult.hasErrors()) {
            return "admin/create/index";
        }


        adminService.insertUser(userDTO);
        return "redirect:/admin/index";
    }
}
