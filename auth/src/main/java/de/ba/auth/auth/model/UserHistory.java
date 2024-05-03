package de.ba.auth.auth.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user-history-table")
public class UserHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
}
