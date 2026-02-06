import java.util.Scanner;

import models.User;

public class App {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        while (true) {  
            System.out.print("Input Name (or 'exit' for exit): "); 
            String name = input.next();
            if (name.equals("exit")) break;

            System.out.print("Input Age: "); 
            int age = input.nextInt();

            System.out.print("Input Email: ");
            String email = input.next();  
            
            try {
                User vova = new User(name, age, email);
                System.out.println(vova);
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        }
        input.close(); 
    }
}
