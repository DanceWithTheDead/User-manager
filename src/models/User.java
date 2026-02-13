package models;

import java.util.concurrent.atomic.AtomicInteger;

public class User {
    
    private static final AtomicInteger COUNTER = new AtomicInteger(0);
    private final int id;
    private String name;
    private String email;
    private int age;

    public User(String name, int age, String email)
    {
        this.id = COUNTER.incrementAndGet();
        setName(name);
        setAge(age);
        setEmail(email);
    }

    public String getName() { return name; }
    
    public String getEmail() { return email; }

    public int getAge() { return age; }
    
    public int getId() { return id; }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be a empty");
        }
        this.name = name;
    } 

    public void setAge(int age) {
        if (age <= 0 || age >= 100) {
            throw new IllegalArgumentException("Age must be beetwen 1 and 99");
        }
        this.age = age;
    }

    public void setEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email canot be a empty");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("\nID: %d\nName: %s\nAge: %d\nEmail: %s\n", id, name, age, email);
    }
}
