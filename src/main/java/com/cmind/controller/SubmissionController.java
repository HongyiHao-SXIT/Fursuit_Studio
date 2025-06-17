package com.cmind.controller;

import com.cmind.entity.Submission;
import com.cmind.service.SubmissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {
    
    private final SubmissionService submissionService;
    
    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @PostMapping
    public ResponseEntity<Submission> submitAssignment(
            @RequestBody Submission submission) {
        return ResponseEntity.ok(submissionService.submitAssignment(submission));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Submission>> getSubmissionsByUser(
            @PathVariable Long userId) {
        return ResponseEntity.ok(submissionService.getSubmissionsByUser(userId));
    }

    @GetMapping("/assignment/{assignmentId}")
    public ResponseEntity<List<Submission>> getSubmissionsByAssignment(
            @PathVariable Long assignmentId) {
        return ResponseEntity.ok(submissionService.getSubmissionsByAssignment(assignmentId));
    }
}