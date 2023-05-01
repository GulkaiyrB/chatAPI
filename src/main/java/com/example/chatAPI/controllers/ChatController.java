package com.example.chatAPI.controllers;

import com.example.chatAPI.models.Chat;
import com.example.chatAPI.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chats")
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/add")
    public Long createChat(@RequestBody Chat chat) {
        return chatService.create(chat);
    }

    @GetMapping("/all")
    public List<Chat> getAllChats() {
        return chatService.getAllChats();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        chatService.deleteChat(id);
    }

    @GetMapping("/{userId}")
    public List<Chat> getChatsByUserId(@PathVariable Long userId) {
        return chatService.getChatsByUserId(userId);
    }

    @GetMapping("/chat/{chatId}")
    public Chat getChatById(@PathVariable Long chatId) {
        return chatService.getChatById(chatId);
    }
}
