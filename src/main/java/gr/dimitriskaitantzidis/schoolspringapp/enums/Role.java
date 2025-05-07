package gr.dimitriskaitantzidis.schoolspringapp.enums;

public enum Role {
    ROLE_ADMIN("ROLE_ADMIN"), ROLE_TEACHER("ROLE_TEACHER"), ROLE_STUDENT("ROLE_STUDENT");

    public final String value;

    Role(String value) {
        this.value = value;
    }
}