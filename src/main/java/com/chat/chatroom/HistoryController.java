package com.chat.chatroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*") // This allows your HTML file to "talk" to this controller
public class HistoryController {

    @Autowired
    private MessageRepository repository;

    @GetMapping("/history/{roomCode}")
    public List<ChatMessage> getChatHistory(@PathVariable String roomCode) {
        // This pulls all old messages for that specific code from MariaDB
        return repository.findByRoomCode(roomCode);
    }
}
