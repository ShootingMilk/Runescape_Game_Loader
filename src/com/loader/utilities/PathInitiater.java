package com.loader.utilities;

import java.io.File;
import java.nio.file.Path;

/**
 * Created by Daniel Courcha at 3:13 PM 8/22/2015
 **/
public class PathInitiater {

    private static PathInitiater instance = new PathInitiater();

    public static PathInitiater getInstance() {
        return instance;
    }

    private String directory = System.getProperty("user.home") + "/RunescapeGameLoader/";

    public void initiate() {
        File file = new File(directory);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public File get(String name) {
        return new File(directory + name);
        }
    }
