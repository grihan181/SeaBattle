package org.example.seawBattle.controller;

import org.example.seawBattle.AssistClasses.SendSymbolAndCoord;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    @MessageMapping("/shots/{roomNumber}")
    @SendTo("/topic/{roomNumber}")
    public SendSymbolAndCoord shooting(SendSymbolAndCoord shot) throws Exception {
        return shot;
    }
}
