package com.example.battleShipv2.GUI;

import javax.swing.*;
import java.awt.*;

public class BoardGUI extends JFrame {

    static int gridSize;
    public static JFrame frame;
    JPanel mainPanel;
    JPanel buttonPanel;
    public static JButton instructionBtn;
    public static JButton playBtn;


    public BoardGUI() {

    }

    public void createMainBoard()
    {
        frame=new JFrame();
        frame.setTitle("Game Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().add(BorderLayout.CENTER);


        //Grid JPanel
        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.CENTER;
        c.gridx=0;
        c.gridy=2;

        //Label:
        JLabel label = new JLabel("Welcome to Battleship! Let's Play!");
        c.insets = new Insets(2, 2, 70, 2);
        c.gridx = 1;
        c.gridy = 0;
        mainPanel.add(label,c);

        //platBtn:
        playBtn=new JButton("New Game");
        playBtn.addActionListener(new MenuListener());
        c.fill = GridBagConstraints.CENTER;
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 1;
        c.gridy = 3;
        mainPanel.add(playBtn,c);

        //Instructions Button:
        instructionBtn=new JButton("Instructions");
        instructionBtn.addActionListener(new MenuListener());
        c.fill = GridBagConstraints.CENTER;
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 1;
        c.gridy = 4;
        mainPanel.add(instructionBtn,c);

        //Main Frame
        frame.setSize(600,600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(mainPanel);


    }


}
