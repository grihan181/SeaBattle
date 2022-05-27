package org.example.seawar.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SeaWarViewController {

    @RequestMapping("SeaWar/{roomNumber}")
    public String getSeaWarPage(@RequestParam String username,
                                @PathVariable String roomNumber, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("roomNumber", roomNumber);
        return "SeaWarCreate.html";
    }
    @RequestMapping("SeaWar/{roomNumber}/field")
    public String getSeaWarPage() {
       return "SeaWar.html";
    }
}
