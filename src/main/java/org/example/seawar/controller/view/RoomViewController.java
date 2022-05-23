package org.example.seawar.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoomViewController {

    @RequestMapping("room")
    public String getRoomPage() {
        return "roomCreate.html";
    }

    @RequestMapping("LogIn/{roomNumber}")
    public String getLogIn(@PathVariable String roomNumber, Model model) {
        model.addAttribute("roomNumber", roomNumber);
        return "LogIn.html";
    }
}
