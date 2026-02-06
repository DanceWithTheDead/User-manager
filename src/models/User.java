package models;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class User{

    private static final AtomicInteger COUNTER = new AtomicInteger(0);
    private final int id;
    private int age;
    private String name;
    private String email;

    public User(String name, int age, String email){
        setName(name);
        setAge(age);
        setEmail(email);
        this.id = COUNTER.incrementAndGet();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "Name canot be null");
    }
    
    public void setAge(int age){
        if (age < 0 || age >= 100) {
            throw new IllegalArgumentException("Age must be beetwen 1 and 99");
        }
        this.age = age;
    }

    public void setEmail(String email){
        Objects.requireNonNull(email, "Email canot be null");
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }

    public String toString(){
        return String.format("ID: %d\nName: %s\nAge: %d\nEmail: %s\n", id, name, age, email);
    }
}