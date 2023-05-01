package com.example.chatAPI.services;

import com.example.chatAPI.models.Chat;
import com.example.chatAPI.models.Message;
import com.example.chatAPI.models.User;
import com.example.chatAPI.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final ChatService chatService;
    private final UserService userService;

    @Autowired
    public MessageService(MessageRepository messageRepository, ChatService chatService, UserService userService) {
        this.messageRepository = messageRepository;
        this.chatService = chatService;
        this.userService = userService;
    }

    public Message sendMessage(Long chatId, Long authorId, String text) {
        Chat chat = chatService.getChatById(chatId);
        User author = userService.getUserById(authorId);
        Message message = new Message();
        message.setChat(chat);
        message.setAuthor(author);
        message.setText(text);

        return messageRepository.save(message);
    }

    public List<Message> getMessagesByChat(Long chatId) {
        Chat chat = chatService.getChatById(chatId);
        return messageRepository.findByChatOrderByCreatedAtDesc(chat);
    }

    public List<Message> getMessagesByAuthor(Long authorId) {
        User author = userService.getUserById(authorId);
        return messageRepository.findByAuthorOrderByCreatedAtDesc(author.getId());
    }


}

