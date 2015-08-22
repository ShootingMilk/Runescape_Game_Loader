package com.loader.frame.panel.game.osrs;

import com.loader.utilities.PathInitiater;
import com.loader.web.Parameters;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Daniel Courcha at 3:01 PM 8/22/2015
 **/
public class RunescapeStub implements AppletStub {

    private Applet applet;

    private static RunescapeStub instance = new RunescapeStub();

    public static RunescapeStub getInstance() {
        return instance;
    }

    public RunescapeStub() {
        try {
            File file = PathInitiater.getInstance().get("Client.jar");
            URL jarFile = new URL("jar", "", "file:" + file.getAbsolutePath() + "!/");
            URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[] { jarFile });
            Class clazz = urlClassLoader.loadClass("client");
            applet = (Applet) clazz.newInstance();
            applet.init();
            applet.start();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Applet getApplet() {
        return applet;
    }

    public void setApplet(Applet applet) {
        this.applet = applet;
    }


    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public URL getDocumentBase() {
        return getCodeBase();
    }

    @Override
    public URL getCodeBase() {
        try {
            return new URL("http://oldschool14.runescape.com/j1");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getParameter(String name) {
        return Parameters.getInstance().getParameters().get(name);
    }

    @Override
    public AppletContext getAppletContext() {
        return null;
    }

    @Override
    public void appletResize(int width, int height) {
        getApplet().resize(width, height);
        }
    }
