package com.chat.chatroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private MessageRepository repository; // This connects to your MariaDB

    // PASTE THE CODE BELOW THIS LINE
    @MessageMapping("/chat/{roomCode}")
    @SendTo("/topic/{roomCode}")
    public ChatMessage sendMessage(@DestinationVariable String roomCode, ChatMessage message) {
        repository.save(message); // This is the line that actually SAVES to the database
        return message; 
    }
}
