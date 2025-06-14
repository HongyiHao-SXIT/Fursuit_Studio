package com.fursuit_studio.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")

public class User {

    @Id
    private Long id;
    private String Account;
    private String Username;
    private String Password;
    private String Intro;    
}
