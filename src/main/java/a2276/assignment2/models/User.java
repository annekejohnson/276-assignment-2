package a2276.assignment2.models;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String name;
    private int height;
    private int weight;
    private String hair;
    public float gpa; // please dont ask why it's public. it wouldn't work while private.
    public User() { 
    }
    public User(String name, int height, int weight, String hair, float gpa) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.hair = hair;
        this.gpa = gpa;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public String getHair() {
        return hair;
    }
    public void setHair(String hair) {
        this.hair = hair;
    }
    public float getGPA() {
        return gpa;
    }
    public void setGPA(float gpa) {
        this.gpa = gpa;
    }
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    
}