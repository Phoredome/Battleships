package com.example.battleShipv2.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener {

    public MenuListener() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()== MainMenu.playBtn)
        {
            //Battleship.resetGame();
            //Battleship.game.setVisible(true);

            //set main board invisible:
//            BattleshipGUI play=new BattleshipGUI(10,700,500);

            //Add sho code
            DrawBoard play=new DrawBoard();

            MainMenu.frame.setVisible(false);
            }

        if (e.getSource()== MainMenu.instructionBtn)
        {
            Instructions rules=new Instructions();
        }
        if (e.getSource()== BackgroundIMG.backToBoardBtn)
        {
            BackgroundIMG.frame.setVisible(false);
            MainMenu.frame.setVisible(true);
        }

    }
}
