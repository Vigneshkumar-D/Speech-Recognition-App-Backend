package com.SpeechRecognitionAppBackend.controller;

import com.SpeechRecognitionAppBackend.entity.SpeechRequest;
import com.SpeechRecognitionAppBackend.service.SpeechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpeechController {

    @Autowired
    SpeechService speechService;

    @PostMapping("/save-speech")
    public ResponseEntity<?> saveSpeech(@RequestBody(required = true) SpeechRequest speechRequest){
        System.out.println("hit con");
        return speechService.saveSpeech(speechRequest);
    }
}
