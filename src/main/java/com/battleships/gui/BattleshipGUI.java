package com.battleships.gui;

import javax.swing.*;
import java.awt.*;

public class BattleshipGUI extends JFrame {

    public static JFrame frame;
    JPanel buttonPanel;
    public static JButton backToBoardBtn;
    public static JButton button[][] = new JButton[10][10];
    public static JTextField txtBox;

    static int rows=10;
    static int columns=10;
    static int gridSize;

    public static JPanel panel = new JPanel();

    public BattleshipGUI(int gridSize, int height, int width) {
        this.gridSize = gridSize;

        frame=new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setPreferredSize(new Dimension(width, height));
        frame.setSize(width,height);
        frame.setVisible(true);
        frame.setTitle("Battleship");
        frame.setResizable(false); //change parameter to true to allow user to resize window

        panel = new JPanel();

        // using a GridBagLayout layout manager for its flexibility.
        // creates grid of rows and columns perfect for the battleship gameboard
        panel.setLayout(new GridBagLayout());

        //button panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(10, 10));

        //set buttonPanel background: /resources/static/radar.jpg
        ImageIcon backgroundImage=new ImageIcon("./src/main/resources/static/radar.jpg");

        JLabel background=new JLabel("",backgroundImage,JLabel.CENTER);
        background.setBounds(0,0,500,700);
        buttonPanel.add(background);


        //
        //buttonPanel.set
        int[][] boatPositions = new int[10][10];

        //simply creating the main GUI, with a 10x10 grid w/ dimensions of 100x100
        for (rows = 0; rows < gridSize; rows++) {
            for (columns = 0; columns < gridSize; columns++) {
                button[rows][columns] = new JButton();
                //button[rows][columns].setBackground(Color.GRAY); //default Gray color is easily interchangable here
                button[rows][columns].setPreferredSize(new Dimension(50, 50));

                button[rows][columns].setOpaque(false);
                button[rows][columns].setContentAreaFilled(false);
                //action listener allows for program to react to user button presses in correct grid quadrant
                //button[rows][columns].addActionListener(boatPositions);
                buttonPanel.add(button[rows][columns]);
            }
        }//end of for

        GridBagConstraints c= new GridBagConstraints();
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 0.65;

        panel.add(buttonPanel, c);

        //back to main window (Board Button)
        backToBoardBtn=new JButton("Back to Main Menu");
        backToBoardBtn.addActionListener(new MenuListener());
        c.gridx = 0;
        c.gridy = 4;
        panel.add(backToBoardBtn, c);

        //results Textbox
        txtBox=new JTextField(20);
        c.gridx = 0;
        c.gridy = 5;
        panel.add(txtBox,c);

        frame.setContentPane(panel);
        frame.pack();


    }//end of constructor


    }
