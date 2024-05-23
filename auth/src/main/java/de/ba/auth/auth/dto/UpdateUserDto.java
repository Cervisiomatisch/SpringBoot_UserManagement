package de.ba.auth.auth.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class UpdateUserDto {
    private int id;

    private String username;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private Date birthday;

    private String department;

    private Boolean isActive;

    private String roles;
}
