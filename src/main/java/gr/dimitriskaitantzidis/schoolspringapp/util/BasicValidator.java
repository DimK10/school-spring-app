package gr.dimitriskaitantzidis.schoolspringapp.util;

public class BasicValidator {
    public static void checkNull(Object object) throws NullPointerException {
        if (object == null) {
            throw new NullPointerException("The object of class " + object.getClass().getName() + " cannot be null");
        }
    }
}
