package org.example.seawar.controller;

import org.example.seawar.AssistClasses.SendSymbolAndCoord;
import org.example.seawar.model.Shots;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class WebSocketController {
    @MessageMapping("/shots/{roomNumber}")
    @SendTo("/topic/{roomNumber}")
    public SendSymbolAndCoord shooting(SendSymbolAndCoord shot) throws Exception {
        return shot;
    }
}
