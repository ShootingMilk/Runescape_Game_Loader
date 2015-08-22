package com.loader.utilities;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Daniel Courcha at 8:08 PM 8/21/2015
 **/
public class FontInstaller {

    public static void initiate() {
        try {
            GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
            graphicsEnvironment.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("resource/font/coolfont.otf")));
            graphicsEnvironment.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("resource/font/runescape_uf.ttf")));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }

    public static void setCustomFont(Component component, String filePath, float size) {
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("resource/font/" + filePath)).deriveFont(size);
            component.setFont(customFont);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
