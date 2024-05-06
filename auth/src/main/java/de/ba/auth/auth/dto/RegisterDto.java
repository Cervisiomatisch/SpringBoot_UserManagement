package de.ba.auth.auth.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class RegisterDto {

    private String username;

    private String password;
}
