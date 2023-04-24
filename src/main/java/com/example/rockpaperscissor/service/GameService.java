package com.example.rockpaperscissor.service;

import com.example.rockpaperscissor.exceptions.InvalidChoiceException;
import com.example.rockpaperscissor.models.Choice;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;


import java.util.Random;

@Log4j2
@Service
public class GameService {

    final Random random = new Random();

    public String play(String playerChoice) {
        log.info("Play Called, Players Choice: {}", playerChoice);
        try {
            Choice choice = Choice.valueOf(playerChoice.toUpperCase());

            Choice computerChoice = Choice.values()[random.nextInt(Choice.values().length)];
            if (choice == computerChoice) {
                return "It's a tie!";
            }
            switch (choice) {
                case ROCK:
                    return (computerChoice == Choice.SCISSOR ? "Player win!" : "Computer wins");
                case PAPER:
                    return (computerChoice == Choice.ROCK ? "Player win!" : "Computer wins");
                case SCISSOR:
                    return (computerChoice == Choice.PAPER ? "Player win!" : "Computer wins");
            }
            return "Invalid choice";
        } catch (IllegalArgumentException e) {
            log.error("Invalid choice: {}", playerChoice);
            throw new InvalidChoiceException("Invalid choice: " + playerChoice);
        }
    }
}
