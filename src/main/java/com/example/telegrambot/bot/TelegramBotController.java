package com.example.telegrambot.bot;

import com.example.telegrambot.dto.BotRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
@RequestMapping("/api/telegram/bot")
@AllArgsConstructor
public class TelegramBotController {

    private final TelegramBot telegramBot;

    @PostMapping("/send-message")
    public ResponseEntity<Void> sendMessage(@Valid @RequestBody BotRequest request) {
        telegramBot.onUpdateReceived(getUpdate(request));
        return ResponseEntity.ok().build();
    }

    private static Update getUpdate(BotRequest request) {
        Update update = new Update();
        Message message = new Message();
        message.setText(request.getText());

        Chat chat = new Chat();
        chat.setId(request.getChatId());
        message.setChat(chat);
        update.setMessage(message);
        return update;
    }
}
