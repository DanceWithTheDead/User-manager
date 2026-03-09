package services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import models.User;

public class UserService {
    private final List<User> users;

    public UserService() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        boolean emailExists = users.stream()
                .anyMatch(user1 -> user1.getEmail().
                        equalsIgnoreCase(user.getEmail()));

        if (emailExists) {
            throw new IllegalArgumentException("User with this email already exists");
        }

        users.add(user);
    }

    public void showAllUsers() {
        if (users.isEmpty()) {
            throw new NoSuchElementException("User list is empty");
        }
        for (User user : users) {
            System.out.println(user);
        }
    }

    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        throw new NoSuchElementException("User not found id: " + id);
    }

    public boolean deleteUser(int id) {
        User delUser = findById(id);

        users.remove(delUser);
        return true;
    }

    public void updateUser(
            int id,
            String name,
            int age,
            String email
    ) {
        User user = findById(id);

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (age <= 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 1 and 150");
        }
        user.setName(name.trim());
        user.setAge(age);
        user.setEmail(email.trim());
    }
}
