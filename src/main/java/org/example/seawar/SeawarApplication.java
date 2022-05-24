package org.example.seawar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SeawarApplication {
	public static void main(String[] args) {
		SpringApplication.run(SeawarApplication.class, args);
	}
}
//Здравствуйте, посдкажите пожалуйста, а есть ли еще способы для перетаскивания кораблей и вставки их в таблицу, кроме как DropAndDrag?