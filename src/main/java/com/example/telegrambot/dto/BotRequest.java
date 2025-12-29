package com.example.telegrambot.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BotRequest {
    @NotNull
    private Long chatId;
    @NotNull
    private String text;
}
