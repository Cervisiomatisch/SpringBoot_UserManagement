package de.ba.auth.auth.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class TableUserDto {
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
