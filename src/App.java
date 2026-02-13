import java.util.Scanner;

import models.User;

public class App {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        while (true) {    
            
            try {
            System.out.print("Input Name (or 'exit' for exit): "); 
            String name = input.nextLine();
            if (name.equals("exit")) break;

            System.out.print("Input Age: "); 
            int age = input.nextInt();
            input.nextLine();

            System.out.print("Input Email: ");
            String email = input.nextLine();
            
            User user = new User(name, age, email);
            System.out.println(user);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        input.close();
    }
}
