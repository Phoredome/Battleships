package com.example.battleShipv2.controller;

import com.example.battleShipv2.GUI.BattleshipGUI_sho;
import com.example.battleShipv2.model.Board;
import com.example.battleShipv2.GUI.IWindow;
import org.springframework.beans.factory.annotation.Autowired;

public class Controller {
    public int x,y;
    @Autowired
    BattleshipGUI_sho gui_sho=new BattleshipGUI_sho();
}
