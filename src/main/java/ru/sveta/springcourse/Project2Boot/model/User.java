package ru.sveta.springcourse.Project2Boot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2,max = 30, message = "Name should be between 2 and 30 characters")
    @Column(name="name")
    @Pattern(regexp = "^[a-zA-Z]*$",message = "Name should be contains only from letters ")
    private String name;
    @NotEmpty(message = "Surname should not be empty")
    @Size(min = 2,max = 30, message = "Surname should be between 2 and 30 characters")
    @Column(name="surname")
    @Pattern(regexp = "^[a-zA-Z]*$",message = "Name should be contains only from letters ")
    private String surname;
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    @Column(name="email")
    private String email;

    public User() {
    }

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}