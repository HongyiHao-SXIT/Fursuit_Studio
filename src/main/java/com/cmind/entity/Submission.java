package com.cmind.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "assignment_id", nullable = false)
    private Assignment assignment;
    
    @Lob
    @Column(nullable = false)
    private String code;
    
    private LocalDateTime submissionTime;
    private Integer score;
    private String feedback;
}