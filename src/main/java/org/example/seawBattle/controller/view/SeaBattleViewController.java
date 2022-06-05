package org.example.seawBattle.controller.view;

import org.example.seawBattle.model.Shots;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SeaBattleViewController {

    @RequestMapping("SeaBattle/{roomNumber}")
    public String getSeaWarPageCreate(@RequestParam String username,
                                @PathVariable String roomNumber, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("roomNumber", roomNumber);
        return "SeaBattleCreate.html";
    }
    @RequestMapping("SeaBattle/{roomNumber}/{username}/field")
    public String getSeaBattlePage(@PathVariable String roomNumber,
                                @PathVariable String username,
                                Model model) {
        model.addAttribute("roomNumber", roomNumber);
        model.addAttribute("username", username);
        return "SeaBattle.html";
    }
    @MessageMapping("/shot")
    @SendTo("/topic/{roomNumber}")
    public Shots shooting(Shots shot) {
        return shot;
    }

}
