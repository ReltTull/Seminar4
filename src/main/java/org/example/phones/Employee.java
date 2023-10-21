package org.example.phones;

public class Employee {

    private static int id = 0;
    private String phoneNumber;
    private final String name;
    private int workExperience;

    public Employee(String phoneNumber, String name, int workExperience) {
        this.id = id++;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.workExperience = workExperience;
    }

    public int getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }
}
