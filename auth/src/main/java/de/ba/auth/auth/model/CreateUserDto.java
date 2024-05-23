package de.ba.auth.auth.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Getter
public class CreateUserDto {

    private int id;

    private String username;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private Date birthday;

    private String department;

    private String password;

    private Boolean isActive;

    private String roles;

}
