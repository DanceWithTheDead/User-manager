package services;

import java.util.ArrayList;
import java.util.List;

import models.User;

public class UserService {
    private List<User> users;

    public UserService(){
        users = new ArrayList<>();
    }

    public void addUser(User user)
    {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be a null");
        }
        users.add(user);
    }

    public void showAllUsers(){
        if (users.isEmpty()) {
            return;
        }
        for (User user : users){
            System.out.println(user);
        }
    }

    public User findById(int id){
        for (User user : users){
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public boolean deleteUser(int id){
        User delUser = findById(id);
        if (delUser == null) {
            return false;
        }
        users.remove(delUser);
        return true;
    }
}
