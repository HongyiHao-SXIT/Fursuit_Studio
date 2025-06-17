package com.cmind.service;

import com.cmind.entity.Submission;
import org.springframework.stereotype.Service;

@Service
public class GradingService {
    
    public void gradeSubmission(Submission submission) {
        // 这里可以实现自动评分逻辑
        // 例如: 运行测试用例对比预期输出
        
        // 简单示例: 根据代码长度给分 (仅示例)
        int codeLength = submission.getCode().length();
        int score = Math.min(100, codeLength / 10);
        submission.setScore(score);
        
        // 添加反馈
        if (score > 80) {
            submission.setFeedback("Excellent work! Your code is well-structured.");
        } else if (score > 50) {
            submission.setFeedback("Good attempt, but could be improved.");
        } else {
            submission.setFeedback("Please review the course materials and try again.");
        }
    }
}