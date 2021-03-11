package com.example.battleShipv2.GUI;

import com.example.battleShipv2.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*
should be renamed to battleshipBoard or draw board
delete mouse move
mouse click code to be moved into battleshipGUI class
controller should implement mouse listener interface
create instance of controller class to be mouse listener
 */
public class DrawBoard extends JFrame {
    int distance = 3;

    private final Controller controller = new Controller();
    private final GameBoard gameBoard = new GameBoard();
    public DrawBoard() {
        this.setTitle("Battleship");
        this.setSize(700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);


        this.setContentPane(gameBoard);

        //For listening to mouse moving
        /*MouseMove mouseMove = new MouseMove();
        this.addMouseMotionListener(mouseMove);*/

        MouseClick mouseClick = new MouseClick();
        this.addMouseListener(mouseClick);

    } // End GUI constructor


    private static class GameBoard extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setLayout(null);
            //Show background image
            ImageIcon img = new ImageIcon("./src/main/resources/static/board.jpg");
            g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
            setVisible(true);
        }// End boardComponent method

    }// End GameBoard class

    /*public class MouseMove implements MouseMotionListener {

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


    }//End MouseMove class*/

    public class MouseClick implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            int[] mousePos = { e.getX(), e.getY() };
            int[] gridTop = { 73, 85 };
            int titleBarOffset = 32;
            int[] tileSize = { 69, 52 };
            // Grid size 7
            int[] gridBottom = {
                    gridTop[0] + tileSize[0] * 7,
                    gridTop[1] + tileSize[1] * 7
            };

            // Make sure mouse is in the actual grid
            if (mousePos[0] < gridTop[0] ||
                    mousePos[0] > gridBottom[0] ||
                    mousePos[1] < gridTop[1] ||
                    mousePos[1] > gridBottom[1]
            ) return; // Ignore the mouse click

            // Find the cell the mouse was clicked in
            int x = (mousePos[0] - gridTop[0]) / tileSize[0];
            int y = (mousePos[1] - gridTop[1]) / tileSize[1];
            System.out.printf("Mouse clicked in cell (%d, %d)%n", x, y);

            //try to register a hit in cell
            ImageIcon img;
            if (controller.hit(x, y)) {
                img = new ImageIcon("./src/main/resources/static/ship.png");

                //Check if Ship Sunk
                if(controller.shipSunk(x,y).alive() == false)
                    System.out.println("Ship Sunk");
            }
            else if (controller.miss(x,y))
                img = new ImageIcon("./src/main/resources/static/miss.png");
            else {
            	JOptionPane.showMessageDialog(null, "Ship Already Hit","Warning", JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("Cell Already Selected");
                return;
            }

            // Draw image in proper cell

            JLabel shipLabel = new JLabel(img);
            gameBoard.add(shipLabel);
            shipLabel.setBounds(
                    x * tileSize[0] + gridTop[0],
                    y * tileSize[1] + gridTop[1] - titleBarOffset,
                    tileSize[0],
                    tileSize[1]
            );
            setVisible(true);


            // Check if the game is won
            if (controller.gameEnd()) {
            int option = JOptionPane.showOptionDialog(null, "Game Finished!", "Congratulations!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            if(option == JOptionPane.OK_OPTION) {
            	System.exit(0);
               }
            }
            	//System.out.println("Game Finished!");
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
