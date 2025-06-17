package com.cmind.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    private String description;
    private String instructor;
    private String thumbnailUrl;
    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<Module> modules;
}