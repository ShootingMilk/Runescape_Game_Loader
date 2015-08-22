package com.loader.frame.panel.game.osrs;

import com.loader.frame.LoaderFrame;
import com.loader.frame.panel.InnerLoadingPanel;
import com.loader.utilities.FontInstaller;
import com.loader.web.Parameters;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Daniel Courcha at 4:08 PM 8/21/2015
 **/
public class OldschoolPanel {

    private JProgressBar jProgressBar;

    private JPanel loadingPanel;

    private JPanel gamePanel;

    private static OldschoolPanel instance = new OldschoolPanel();

    public static OldschoolPanel getInstance() {
        return instance;
    }

    public void createPanel() throws Exception {
        LoaderFrame.getInstance().removeComponent(InnerLoadingPanel.getInstance());
        initialiseComponents();
        addComponentActions();
        addComponents();
        addLayout();
    }

    private void initialiseComponents() {
        loadingPanel = new JPanel();
        jProgressBar = new JProgressBar();
    }

    private void addLayout() {
        loadingPanel.setLayout(new GridLayout(1, 1));
    }

    public void updateStatus(String text, Color color, int value) {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                Thread.sleep(1000);
                return null;
            }

            @Override
            protected void done() {
                jProgressBar.setString(text + "          " + value + "%");
                jProgressBar.setValue(value);
                jProgressBar.setForeground(color);
                FontInstaller.setCustomFont(jProgressBar, "runescape_uf.ttf", 16f);
            }
        };
        worker.execute();
    }

    private void addComponentActions() {
        jProgressBar.setStringPainted(true);
    }

    private boolean loadingProcessComplete() {
        return jProgressBar.getValue() == 60;
    }

    private void addComponents() throws Exception {
        loadingPanel.add(jProgressBar);
        LoaderFrame.getInstance().resizeFrameD(350, 110, false);
        LoaderFrame.getInstance().setTitle("OSRS Game Loader!");
        LoaderFrame.getInstance().addComponentToContentPane(loadingPanel);
        updateStatus("Updating Oldschool Game Parameters!", Color.MAGENTA, 20);
        Parameters.getInstance().grabParameters("OSRS");
        updateStatus("Checking for OSRS Game Updates!", Color.GREEN, 40);
        // TODO Check for game update!
        updateStatus("Downloading new OSRS Update!", Color.RED, 60);
        // TODO Download Manager!
        if (loadingProcessComplete()) {
            addContent();
        }
    }

    private void addContent() {
        System.out.println("Complete!");
        updateStatus("Loading OSRS Game Applet!", Color.YELLOW, 80);
        // TODO load osrs applet
        updateStatus("Initiating OSRS Game Applet!", Color.BLACK, 100);
    }
    }
