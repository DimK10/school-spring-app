package gr.dimitriskaitantzidis.schoolspringapp.enums;


import gr.dimitriskaitantzidis.schoolspringapp.util.Constants;

public enum Role {
    ROLE_ADMIN(Constants.ROLE_ADMIN), ROLE_TEACHER(Constants.ROLE_TEACHER), ROLE_STUDENT(Constants.ROLE_STUDENT);

    public final String value;

    Role(String value) {
        this.value = value;
    }

    public String getAbbreviated() {
        return this.value.substring(5);
    }
}
