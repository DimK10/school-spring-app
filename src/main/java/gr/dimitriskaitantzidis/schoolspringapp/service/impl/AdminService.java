package gr.dimitriskaitantzidis.schoolspringapp.service.impl;

import gr.dimitriskaitantzidis.schoolspringapp.dto.UserDTO;
import gr.dimitriskaitantzidis.schoolspringapp.service.IAdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements IAdminService {
    @Override
    public List<UserDTO> getAllUsersOrderByName() {
        return List.of();
    }

    @Override
    public void insertUser(UserDTO userDTO) {

    }

    @Override
    public void updateUser(UserDTO userDTO) {

    }

    @Override
    public void deleteUser(UserDTO userDTO) {

    }
}
