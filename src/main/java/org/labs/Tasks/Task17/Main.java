package org.labs.Tasks.Task17;

public class Main {
    public static void main(String[] args) {
        User user = new User(null, "LongUsernameHere", 16);

        try {
            Validator.validate(user);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
