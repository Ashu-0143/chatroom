package com.chat.chatroom;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<ChatMessage, Long> {
    // Make sure the "roomCode" here matches the variable name in ChatMessage.java
    List<ChatMessage> findByRoomCode(String roomCode);
}
