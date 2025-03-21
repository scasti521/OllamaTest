package com.sergio.ollamatest.controller;

import com.sergio.ollamatest.service.def.AiService;
import com.sergio.ollamatest.service.impl.AiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    private final AiServiceImpl aiService;

    @Autowired
    public AiController(AiServiceImpl aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/prompt")
    public ResponseEntity<String> getResponse(@RequestBody String prompt) {
        String response = aiService.sendPrompt(prompt);
        return ResponseEntity.ok(response);
    }
}