package org.example.seawar.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoomViewController {

    @RequestMapping("room")
    public String getRoomPage() {
        return "roomCreate.html";
    }

    @RequestMapping("LogIn")
    public String getLogIn() {
        return "LogIn.html";
    }
}
