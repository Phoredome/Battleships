package com.example.battleShipv2;

import com.example.battleShipv2.GUI.MainMenu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class BattleShipV2Application extends JFrame{

	public static void main(String[] args) {

		SpringApplication.run(BattleShipV2Application.class, args);
		MainMenu board = new MainMenu();

		//setSampleEnemyBoatBoard();

		board.createMainBoard();

		//to call/show the board window
		//board.setSize(400,400);
		//board.setVisible(true);
		//or call the method which makes JFrame from BoardGUI class, like below:
		//demo();
	}

}
