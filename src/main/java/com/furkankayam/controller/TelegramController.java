package com.furkankayam.controller;

import com.furkankayam.bot.TelegramBot;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/telegram")
@RequiredArgsConstructor
public class TelegramController {

    private final TelegramBot telegramBot;

    @GetMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam String message) {
        try {
            telegramBot.sendMessageToAll(message);
            return ResponseEntity.ok("✅ Mesaj herkese gönderildi!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("❌ Hata: " + e.getMessage());
        }
    }
}