package com.loader.frame.panel;

import com.loader.frame.LoaderFrame;
import com.loader.frame.panel.game.GameLoadingPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Daniel Courcha at 8:17 PM 8/20/2015
 **/
public class InnerLoadingPanel extends JPanel {

    private JButton RS3;

    private JButton OSRS;

    private ImageIcon RS3Icon;

    private ImageIcon OSRSIcon;

    private static InnerLoadingPanel instance = new InnerLoadingPanel();

    public static InnerLoadingPanel getInstance() {
        return instance;
    }

    public InnerLoadingPanel() {
    }

    private void initialiseComponents() {
        RS3Icon = new ImageIcon("resource/images/RS3Icon.png");
        OSRSIcon = new ImageIcon("resource/images/OSRSIcon.png");
        RS3 = new JButton();
        OSRS = new JButton();
        createComponents();
        addComponentActions();
    }

    private void createComponents() {
        RS3.setIcon(RS3Icon);
        OSRS.setIcon(OSRSIcon);
        add(RS3);
        add(OSRS);
        setLayout(new GridLayout(1, 2));
    }

    private void addComponentActions() {
        RS3.addActionListener(e -> {
            // Create RS3 Loader
            try {
                new GameLoadingPanel(GameLoadingPanel.GameType.RS3);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        OSRS.addActionListener(e -> {
            // Create OSRS Loader
            try {
                new GameLoadingPanel(GameLoadingPanel.GameType.OSRS);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
    }

    public void createPanel() {
        initialiseComponents();
        LoaderFrame.getInstance().setTitle("Game Selector Panel");
        LoaderFrame.getInstance().resizeFrameD(935, 603, false);
        LoaderFrame.getInstance().addComponentToContentPane(this);
        }
    }
