package gr.dimitriskaitantzidis.schoolspringapp.service.impl;

import gr.dimitriskaitantzidis.schoolspringapp.dao.IUserDAO;
import gr.dimitriskaitantzidis.schoolspringapp.dto.StudentDTO;
import gr.dimitriskaitantzidis.schoolspringapp.dto.TeacherDTO;
import gr.dimitriskaitantzidis.schoolspringapp.dto.UserDTO;
import gr.dimitriskaitantzidis.schoolspringapp.service.IAdminService;
import gr.dimitriskaitantzidis.schoolspringapp.util.Constants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements IAdminService {

    private final IUserDAO userDAO;

    public AdminService(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<UserDTO> getAllUsersOrderByName() {
        return userDAO.getAllUsersOrderByName();
    }

    @Override
    public Optional<UserDTO> getUserDTOByUserId(Integer userId) throws SQLException {
        return userDAO.getUserDTOById(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void insertUser(UserDTO userDTO) throws SQLException {
        switch (userDTO.getRole()) {
            case Constants.ROLE_TEACHER ->
                    userDTO.setTeacherDTO(new TeacherDTO(0, userDTO.getName().substring(0, 1), userDTO.getName().substring(1)));
            case Constants.ROLE_STUDENT -> userDTO.setStudentDTO(new StudentDTO(0, userDTO.getName()));
        }
        userDAO.saveUser(userDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void updateUser(UserDTO userDTO) throws SQLException {
        switch (userDTO.getRole()) {
            case Constants.ROLE_TEACHER ->
                    userDTO.setTeacherDTO(new TeacherDTO(0, userDTO.getName().substring(0, 1), userDTO.getName().substring(1)));
            case Constants.ROLE_STUDENT -> userDTO.setStudentDTO(new StudentDTO(0, userDTO.getName()));
        }
        userDAO.updateUser(userDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void deleteUser(UserDTO userDTO) throws SQLException {
        userDAO.deleteUser(userDTO.getUserId());
    }
}
