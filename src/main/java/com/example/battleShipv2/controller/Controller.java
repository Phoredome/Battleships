package com.example.battleShipv2.controller;

import com.example.battleShipv2.GUI.BattleshipGUI;
import com.example.battleShipv2.model.Board;
import com.example.battleShipv2.GUI.IWindow;
import org.springframework.beans.factory.annotation.Autowired;

public class Controller {
    public int x,y;
    @Autowired
    BattleshipGUI gui_sho=new BattleshipGUI();
}
