package com.example.chatAPI.repository;

import com.example.chatAPI.models.Chat;
import com.example.chatAPI.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByChatOrderByCreatedAtDesc(Chat chat);

    @Query("SELECT m FROM Message m WHERE m.author.id = :authorId ORDER BY m.createdAt DESC")
    List<Message> findByAuthorOrderByCreatedAtDesc(@Param("authorId") Long authorId);


}
