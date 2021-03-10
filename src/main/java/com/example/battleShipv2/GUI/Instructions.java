package com.example.battleShipv2.GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Instructions extends JFrame {

    static JButton ToMainMenuBtn;
    public JFrame ruleWindow;
    JTextArea text;

    public Instructions() {

        ruleWindow=new JFrame();
        ruleWindow.setTitle("Battleship Instructions");
        ruleWindow.setSize(900,300);
        ruleWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //create JPanel
        JPanel rulespanel = new JPanel();

        //set boarder for the RulePanel
        rulespanel.setBorder(new LineBorder(Color.pink,40));

        text = new JTextArea("Game Instructions\n1) When the game starts you may begin to place your ships, you will first have the opportunity to place your one-tile sized ships (there are 4 one-tile ships). \n2) You can place your two-tile ships by clicking on a tile and then a tile next to the first tile to orient the ship (there are 3 two-tile ships).\n3) Continue to place three-tile ships(amount: 2) and four-tile ship (amount: 1)\n4) Once you have placed all your ships the board will disappear and the opponent board will become visible, entering the attack stage.\n5) Click on the tiles you wish to fire torpedoes, a blue tile represents a missed shot, a red tile represents a hit.\n6) Once all your opponent's ships are sunk you win!");
        text.setRows(10);
        text.setColumns(10);
        rulespanel.add(text);

        //add Jpanel to JFrame
        ruleWindow.add(rulespanel);
        ruleWindow.setResizable(true);
        ruleWindow.setVisible(true);
        ruleWindow.pack();

    }
}
