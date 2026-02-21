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
            System.out.println("5: Exit");
            System.out.println("-----------------");
            System.out.print("Choose options: ");

            int choise;

            try{
                choise = input.nextInt();
                input.nextLine();
            } catch (Exception e){
                System.out.println("Enter a number");
                input.nextLine();
                continue;
            }

            switch (choise) {
                case 1:
                    try{
                        System.out.print("Enter name: ");
                        String name = input.nextLine();

                        System.out.print("Enter age: ");
                        int age = input.nextInt();
                        input.nextLine();

                        System.out.print("Enter email: ");
                        String email = input.nextLine();

                        User user = new User(name, age, email);
                        userService.addUser(user);
                    } catch (Exception e){
                        System.out.println("Error: " + e.getMessage());
                        input.nextLine();
                    }
                    break;

                case 2:
                    userService.showAllUsers();
                    break;

                case 3:
                    System.out.print("Enter user id: ");
                    int findId = input.nextInt();
                    input.nextLine();

                    User foundUser = userService.findById(findId);

                    if (foundUser == null) {
                        System.out.println("User not found");
                    } else{
                        System.out.println(foundUser);
                    } 
                    break;

                case 4:
                    System.out.print("Enter user id: ");
                    int deleteId = input.nextInt();
                    input.nextLine();
                    boolean deleted = userService.deleteUser(deleteId);

                    if (deleted) {
                        System.out.println("Deleted user successfully");
                    } else {
                        System.out.println("User not found");
                    }
                    break;

                case 5:
                    System.out.println("Bye");
                    input.close();
                    return;    

                default:
                    System.out.println("Unknown command");
            }   
        }
    }
}
