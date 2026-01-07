package com2.The_office.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "JuniorDev")
public class JuniorDev {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "salary")
    private Double salary;
    @Column(name = "employeeType")
    private String employeeType;
    @Column(name = "department")
    private String department;
    @Column(name = "mainSkill")
    private String mainSkill;
}
