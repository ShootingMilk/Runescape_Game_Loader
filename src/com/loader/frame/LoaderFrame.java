package com.loader.frame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Daniel Courcha at 8:16 PM 8/20/2015
 **/
public class LoaderFrame {

    private JFrame frame;

    private Dimension d = new Dimension(800, 600);

    private JButton settingsButton;

    private ImageIcon settingsIcon;

    private JMenuBar jMenuBar;

    private static LoaderFrame instance = new LoaderFrame();

    public static LoaderFrame getInstance() {
        return instance;
    }

    public void createFrame() {
        settingsIcon = new ImageIcon("resource/images/settingsIcon.png");
        settingsButton = new JButton();
        settingsButton.setIcon(settingsIcon);
        jMenuBar = new JMenuBar();
        jMenuBar.add(settingsButton);
        frame = new JFrame();
        frame.setJMenuBar(jMenuBar);
        frame.setPreferredSize(d);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setTitle(String title) {
        frame.setTitle(title);
    }

    public Component[] getComponents() {
        return frame.getComponents();
    }

    public void getComponent(int componentIndex){
        frame.getComponent(componentIndex);
    }

    public void setComponentName(String title, Component component) {
        component.setName(title);
    }

    public void addComponent(Component component) {
        frame.add(component);
    }

    public void addComponentToContentPane(Component component) {
        frame.getContentPane().add(component);
    }

    public void removeComponent(Component component) {
        frame.remove(component);
    }

    public void resizeFrameD(int width, int height, boolean set) {
        if (!set) {
            frame.resize(new Dimension(width, height));
        }
        frame.setSize(new Dimension(width, height));
    }

    public void resizeFrame(int width, int height, boolean set) {
        if (!set) {
            frame.resize(width, height);
        }
        frame.setSize(width, height);
    }

    public void resizeFrame(Dimension d, boolean set) {
        if (!set) {
            frame.resize(d);
        }
        frame.setSize(d);
    }

    public void removeAllComponents() {
        frame.removeAll();
    }
    }
