package gr.dimitriskaitantzidis.schoolspringapp.service;

import gr.dimitriskaitantzidis.schoolspringapp.dto.UserDTO;

import java.sql.SQLException;
import java.util.List;

public interface IAdminService {

    List<UserDTO> getAllUsersOrderByName();

    void insertUser(UserDTO userDTO) throws SQLException;

    void updateUser(UserDTO userDTO) throws SQLException;

    void deleteUser(UserDTO userDTO) throws SQLException;
}
