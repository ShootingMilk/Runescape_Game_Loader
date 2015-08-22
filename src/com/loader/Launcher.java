package com.loader;

import com.loader.frame.LoaderFrame;
import com.loader.frame.panel.InnerLoadingPanel;
import com.loader.utilities.FontInstaller;
import com.loader.utilities.PathInitiater;
import org.pushingpixels.substance.api.skin.SubstanceBusinessBlueSteelLookAndFeel;

import javax.swing.*;

/**
 * Created by Daniel Courcha at 8:15 PM 8/20/2015
 **/
public class Launcher {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame.setDefaultLookAndFeelDecorated(true);
            try {
                UIManager.setLookAndFeel(new SubstanceBusinessBlueSteelLookAndFeel());
            } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
            PathInitiater.getInstance().initiate();
            FontInstaller.initiate();
            LoaderFrame.getInstance().createFrame();
            InnerLoadingPanel.getInstance().createPanel();
        });
    }
}
