package gr.dimitriskaitantzidis.schoolspringapp.dao;

import gr.dimitriskaitantzidis.schoolspringapp.dto.UserDTO;
import gr.dimitriskaitantzidis.schoolspringapp.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IUserDAO {

    Optional<User> getUserByEmail(String email);

    Optional<User> getUserById(int id) throws SQLException;

    Optional<UserDTO> getUserDTOById(int id) throws SQLException;

    List<UserDTO> getAllUsersOrderByName();

    void saveUser(UserDTO userDTO) throws SQLException, IllegalArgumentException;

    void updateUser(UserDTO user) throws SQLException, IllegalArgumentException;

    void deleteUser(int id) throws SQLException, IllegalArgumentException;
}
