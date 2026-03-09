import java.util.NoSuchElementException;
import java.util.Scanner;

import models.User;
import services.UserService;

public class App {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        UserService userService = new UserService();

        while (true) {
            System.out.println("-----------------");
            System.out.println("1: Create User");
            System.out.println("2: Show All Users");
            System.out.println("3: Find User");
            System.out.println("4: Delete User");
            System.out.println("5: Update user");
            System.out.println("6: Exit");
            System.out.println("-----------------");
            System.out.print("Choose options: ");

            int choice;

            try {
                choice = input.nextInt();
                input.nextLine();
            } catch (Exception e) {
                System.out.println("Enter a number");
                input.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter name: ");
                        String name = input.nextLine();
                        if (name.trim().isEmpty()) {
                            throw new IllegalArgumentException("Name cannot be empty");
                        }

                        System.out.print("Enter age: ");
                        int age;
                        try {
                            age = Integer.parseInt(input.nextLine());
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException("Please enter a valid number for age");
                        }

                        System.out.print("Enter email: ");
                        String email = input.nextLine();

                        User user = new User(name.trim(), age, email.trim().toLowerCase());
                        userService.addUser(user);
                        System.out.println("User created successfully!");

                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        userService.showAllUsers();
                    } catch (NoSuchElementException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter user id: ");
                    int findId = input.nextInt();
                    input.nextLine();
                    try {
                        User foundUser = userService.findById(findId);
                        if (foundUser == null) {
                            break;
                        } else {
                            System.out.println(foundUser);
                        }

                    } catch (NoSuchElementException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter user id: ");
                    int deleteId = input.nextInt();
                    input.nextLine();
                    try {
                        boolean deleted = userService.deleteUser(deleteId);

                        if (deleted) {
                            System.out.println("Deleted user successfully");
                        } else {
                            System.out.println("User not found");
                        }

                    } catch (NoSuchElementException e) {
                        System.out.println("Error:" + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.print("Enter user id: ");
                    int updateId = input.nextInt();
                    input.nextLine();

                    try {
                        User existingUser = userService.findById(updateId);
                        if (existingUser == null) {
                            break;
                        }

                        System.out.println("Updating user: " + existingUser.getName());

                        System.out.print("Enter new name (or press Enter to keep current): ");
                        String name = input.nextLine();
                        if (name.trim().isEmpty()) {
                            name = existingUser.getName();
                        }

                        System.out.print("Enter new age (or press Enter to keep current): ");
                        String ageInput = input.nextLine();
                        int age;
                        if (ageInput.trim().isEmpty()) {
                            age = existingUser.getAge();
                        } else {
                            age = Integer.parseInt(ageInput);
                        }

                        System.out.print("Enter new email (or press Enter to keep current): ");
                        String email = input.nextLine();
                        if (email.trim().isEmpty()) {
                            email = existingUser.getEmail();
                        }

                        userService.updateUser(updateId, name, age, email);
                        System.out.println("User updated successfully!");
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Please enter a valid number for age");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Validation error: " + e.getMessage());
                    } catch (NoSuchElementException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Bye!");
                    input.close();
                    return;

                default:
                    System.out.println("Unknown command");
            }
        }
    }
}
