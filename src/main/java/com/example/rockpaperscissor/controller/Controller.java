package com.example.rockpaperscissor.controller;

import com.example.rockpaperscissor.service.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/api/v1/game")
public class Controller {

    final GameService service;

    public Controller(GameService gameService) {
        this.service = gameService;
    }

    @GetMapping("/play")
    public String play(@RequestParam String choice) {
        log.info("Players Choice: {}", choice);
        return service.play(choice);
    }


    @GetMapping("/health-check")
    public String isAlive() {
        return "Running... " + LocalDateTime.now();
    }

}
