package de.ba.auth.auth.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
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
