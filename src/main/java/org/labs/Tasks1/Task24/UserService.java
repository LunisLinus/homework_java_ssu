package org.labs.Tasks1.Task24;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public class UserService {
    private final UserDAO userDAO;
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    public UserService() {
        this.userDAO = new UserDAOImpl();
    }

    public void registerUser(String name, String email) throws SQLException {
        validateName(name);
        validateEmail(email);
        if (userDAO.emailExists(email)) {
            throw new IllegalArgumentException("Email уже существует.");
        }
        User user = new User(name, email);
        userDAO.create(user);
        System.out.println("Пользователь добавлен: " + user);
    }

    public List<User> listAllUsers() throws SQLException {
        return userDAO.findAll();
    }

    public void deleteUser(int id) throws SQLException {
        User user = userDAO.findById(id);
        if (user == null) {
            throw new IllegalArgumentException("Пользователь с ID " + id + " не найден.");
        }
        userDAO.delete(id);
        System.out.println("Пользователь удалён: " + user);
    }

    public void updateUser(int id, String newName, String newEmail) throws SQLException {
        User user = userDAO.findById(id);
        if (user == null) {
            throw new IllegalArgumentException("Пользователь с ID " + id + " не найден.");
        }
        validateName(newName);
        validateEmail(newEmail);
        if (!user.getEmail().equals(newEmail) && userDAO.emailExists(newEmail)) {
            throw new IllegalArgumentException("Email уже существует.");
        }
        user.setName(newName);
        user.setEmail(newEmail);
        userDAO.update(user);
        System.out.println("Пользователь обновлён: " + user);
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }
    }

    private void validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email не может быть пустым.");
        }
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Неверный формат email.");
        }
    }
}

