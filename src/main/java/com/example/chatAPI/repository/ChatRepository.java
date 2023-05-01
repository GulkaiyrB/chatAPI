package com.example.chatAPI.repository;

import com.example.chatAPI.models.Chat;
import com.example.chatAPI.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findByUsers(User user);


}


