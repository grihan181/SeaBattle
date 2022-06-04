package org.example.seawar.controller.view;

import org.example.seawar.model.Shots;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SeaWarViewController {

    @RequestMapping("SeaWar/{roomNumber}")
    public String getSeaWarPageCreate(@RequestParam String username,
                                @PathVariable String roomNumber, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("roomNumber", roomNumber);
        return "SeaWarCreate.html";
    }
    @RequestMapping("SeaWar/{roomNumber}/{username}/field")
    public String getSeaWarPage(@PathVariable String roomNumber,
                                @PathVariable String username,
                                Model model) {
        model.addAttribute("roomNumber", roomNumber);
        model.addAttribute("username", username);
        return "SeaWar.html";
    }
    @MessageMapping("/shot")
    @SendTo("/topic/{roomNumber}")
    public Shots shooting(Shots shot) {
        return shot;
    }

}
