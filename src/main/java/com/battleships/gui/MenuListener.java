package com.battleships.gui;

import com.battleships.controller.MouseEventHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener {

    public MenuListener() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==BoardGUI.playBtn)
        {
            //Battleship.resetGame();
            //Battleship.game.setVisible(true);

            //set main board invisible:
//            BattleshipGUI paly=new BattleshipGUI(10,700,500);

            //Add sho code
            MouseEventHandler paly=new MouseEventHandler();

            BoardGUI.frame.setVisible(false);
            }

        if (e.getSource()==BoardGUI.instructionBtn)
        {
            Instructions rules=new Instructions();
        }
        if (e.getSource()== BattleshipGUI.backToBoardBtn)
        {
            BattleshipGUI.frame.setVisible(false);
            BoardGUI.frame.setVisible(true);
        }

    }
}
