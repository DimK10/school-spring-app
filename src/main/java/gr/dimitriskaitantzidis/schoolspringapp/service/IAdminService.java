package gr.dimitriskaitantzidis.schoolspringapp.service;

import gr.dimitriskaitantzidis.schoolspringapp.dto.UserDTO;

import java.util.List;

public interface IAdminService {

    List<UserDTO> getAllUsersOrderByName();

    void insertUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    void deleteUser(UserDTO userDTO);
}
