package com.loader.frame.panel.game;

import com.loader.frame.LoaderFrame;
import com.loader.frame.panel.InnerLoadingPanel;
import com.loader.frame.panel.game.osrs.OldschoolPanel;
import com.loader.frame.panel.game.rs3.Runescape3Panel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Daniel Courcha at 12:45 PM 8/21/2015
 **/
public class GameLoadingPanel extends JPanel {

    public enum GameType { RS3, OSRS }

    private GameType gameType;

    public GameLoadingPanel(GameType gameType) throws Exception {
        this.gameType = gameType;
        switch (gameType) {
            case OSRS:
                OldschoolPanel.getInstance().createPanel();
                break;
            case RS3:
                Runescape3Panel.getInstance().createPanel();
                break;
        }
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public GameType getGameType() {
        return gameType;
    }

    private void setColor(Component component, Color color) {
        component.setForeground(color);
        }
    }
