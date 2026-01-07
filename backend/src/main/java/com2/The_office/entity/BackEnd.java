package com2.The_office.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "back_end")
public class BackEnd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "salary")
    private double salary;

    @Column(name = "employeeType")
    private String employeeType;

    @Column(name = "department")
    private String department;

    @Column(name = "mainSkill")
    private String mainSkill;

    // No-args constructor
    public BackEnd() {}

    // All-args constructor
    public BackEnd(Long id, String firstName, String lastName, String email, String phone,
                   double salary, String employeeType, String department, String mainSkill) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.employeeType = employeeType;
        this.department = department;
        this.mainSkill = mainSkill;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getEmployeeType() { return employeeType; }
    public void setEmployeeType(String employeeType) { this.employeeType = employeeType; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getMainSkill() { return mainSkill; }
    public void setMainSkill(String mainSkill) { this.mainSkill = mainSkill; }
}
