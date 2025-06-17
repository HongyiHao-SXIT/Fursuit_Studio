package com.cmind.service;

import org.springframework.stereotype.Service;
import java.io.*;
import java.util.concurrent.TimeUnit;

@Service
public class CodeExecutionService {
    
    public String executeCode(String code, String language) throws IOException, InterruptedException {
        // 创建临时文件
        File tempFile = File.createTempFile("code_", getFileExtension(language));
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write(code);
        }
        
        // 根据语言选择执行命令
        ProcessBuilder builder = new ProcessBuilder();
        switch (language.toLowerCase()) {
            case "python":
                builder.command("python", tempFile.getAbsolutePath());
                break;
            case "java":
                // 需要更复杂的Java代码执行逻辑
                builder.command("java", tempFile.getAbsolutePath());
                break;
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }
        
        // 执行代码
        Process process = builder.start();
        boolean finished = process.waitFor(10, TimeUnit.SECONDS);
        
        // 读取输出
        StringBuilder output = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        }
        
        // 读取错误
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getErrorStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                output.append("ERROR: ").append(line).append("\n");
            }
        }
        
        // 删除临时文件
        tempFile.delete();
        
        return output.toString();
    }
    
    private String getFileExtension(String language) {
        switch (language.toLowerCase()) {
            case "python": return ".py";
            case "java": return ".java";
            default: return ".txt";
        }
    }
}