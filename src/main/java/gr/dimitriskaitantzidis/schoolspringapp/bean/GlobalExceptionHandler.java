package gr.dimitriskaitantzidis.schoolspringapp.bean;

import gr.dimitriskaitantzidis.schoolspringapp.service.exceptions.teacher.TeacherNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TeacherNotFoundException.class)
    public String handleException(TeacherNotFoundException ex, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("errorMessage", ex.getMessage());
        return "redirect:/error/500";
    }
}