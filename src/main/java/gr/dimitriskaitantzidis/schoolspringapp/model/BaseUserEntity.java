package gr.dimitriskaitantzidis.schoolspringapp.model;

import gr.dimitriskaitantzidis.schoolspringapp.dto.UserDTO;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;

@MappedSuperclass
public abstract class BaseUserEntity extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "U_id", referencedColumnName = "id")
    protected User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDTO toUserDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(this.getUser().getId());
        return userDTO;
    }
}