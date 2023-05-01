package com.example.chatAPI.controllers;

import com.example.chatAPI.models.Message;
import com.example.chatAPI.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/{chatId}/{authorId}")
    public void sendMessage(@PathVariable Long chatId, @PathVariable Long authorId, @RequestBody String text) {
        messageService.sendMessage(chatId, authorId, text);
    }

    @GetMapping("/chat/{chatId}")
    public List<Message> getMessagesByChat(@PathVariable Long chatId) {
        return messageService.getMessagesByChat(chatId);
    }

    @GetMapping("/author/{authorId}")
    public List<Message> getMessagesByAuthor(@PathVariable Long authorId) {
        return messageService.getMessagesByAuthor(authorId);
    }
}
