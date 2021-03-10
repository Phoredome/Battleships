package com.battleships.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class BattleshipGUI_sho  extends JFrame {
    int distance = 3;

    public int x;
    public int y;
    private int cellWidth=50;
    private int cellHeight=60;

    public BattleshipGUI_sho() {
        this.setTitle("Battleship");
        this.setSize(700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

        GameBoard gameBoard = new GameBoard();
        this.setContentPane(gameBoard);

        //For listening to mouse moving
        MouseMove mouseMove = new MouseMove();
        this.addMouseMotionListener(mouseMove);

        MouseClick mouseClick = new MouseClick();
        this.addMouseListener(mouseClick);

    } // End GUI constructor


    public class GameBoard extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //Show background image
            ImageIcon img = new ImageIcon("D:/Winter2021/Soft3275/MiniProject/Battleship/Battleship/src/main/resources/static/gifs/board.jpg");
            g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
            setVisible(true);

        }// End boardComponent method

    }// End GameBoard class

    public class MouseMove implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {

        }//End mouseDragged class

        @Override
        public void mouseMoved(MouseEvent e) {
            x = Math.abs((e.getX() - distance) / cellWidth);
            y = Math.abs((e.getY() - distance) / cellHeight);
            if(x==3 && y==7) {
                JFrame frame = new JFrame("Show Message Dialog");
                JOptionPane.showMessageDialog(frame, "hit");
            }
            System.out.println(x + " " + y);
        }//End mouseMoved class


    }//End MouseMove class

    public class MouseClick implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
//            x = Math.abs((e.getX() - distance) / cellWidth);
//            y = Math.abs((e.getY() - distance) / cellHeight);
//            ImageIcon img = new ImageIcon("D:/Winter2021/Soft3275/ClassProjects/testGrid2/src/ship.png");
//            g1.drawImage(img.getImage(), x, y,80,80, null);
//            setVisible(true);
//            JLabel label2 = new JLabel(img);
//            add(label2);
            JFrame frame = new JFrame("Show Message Dialog");
            x = Math.abs((e.getX() - distance) / cellWidth);
            y = Math.abs((e.getY() - distance) / cellHeight);
            ImageIcon img = new ImageIcon("D:/Winter2021/Soft3275/MiniProject/Battleship/Battleship/src/main/resources/static/gifs/ship.png");
            JLabel label2 = new JLabel(img);
            label2.setBounds(e.getX(), e.getY(), 80, 80);
            add(label2);
            setVisible(true);
        }// End mouseClicked method

        @Override
        public void mousePressed(MouseEvent e) {
        }// End mousePressed method

        @Override
        public void mouseReleased(MouseEvent e) {

        }// End mouseReleased method

        @Override
        public void mouseEntered(MouseEvent e) {

        }// End mouseEntered method

        @Override
        public void mouseExited(MouseEvent e) {

        }// End mouseExited method
    }// End MouseClick class
}// End BattleshipGUI class
