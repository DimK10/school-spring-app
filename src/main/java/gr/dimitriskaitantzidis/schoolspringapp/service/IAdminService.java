package gr.dimitriskaitantzidis.schoolspringapp.service;

import gr.dimitriskaitantzidis.schoolspringapp.dto.UserDTO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IAdminService {

    List<UserDTO> getAllUsersOrderByName();

    Optional<UserDTO> getUserDTOByUserId(Integer userId) throws SQLException;

    void insertUser(UserDTO userDTO) throws SQLException;

    void updateUser(UserDTO userDTO) throws SQLException;

    void deleteUser(UserDTO userDTO) throws SQLException;
}
