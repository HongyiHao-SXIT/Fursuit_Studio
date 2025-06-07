package com.fursuit_studio.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@NoArgsConstructor

public class User {
    private String Account;
    private String Username;
    private String Password;
    private String Intro;    
}
