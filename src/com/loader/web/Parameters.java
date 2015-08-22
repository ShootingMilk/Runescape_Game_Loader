package com.loader.web;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by Daniel Courcha at 11:45 PM 8/21/2015
 **/
public class Parameters {

    private Map<String, String> parameters;

    private Map<String, String> data;

    private static Parameters instance = new Parameters();

    public static Parameters getInstance() {
        return instance;
    }

    public void grabParameters(String gameType) throws Exception {
        if (gameType.equals("RS3")) {
            // Grab RS3 Parameters!
        } else if (gameType.equals("OSRS")) {
            HashMap parameters = new HashMap();
            HashMap data = new HashMap();
            URL source = new URL("http://oldschool14.runescape.com/jav_config.ws");
            String[] lines = getStrings(source);
            int var7 = lines.length;
            for (int var6 = 0; var6 < var7; ++var6) {
                String line = lines[var6];
                String key = line.substring(0, line.indexOf(61));
                switch (key.hashCode()) {
                    case 108417:
                        if (key.equals("msg")) {
                            continue;
                        }
                        break;
                    case 106436749:
                        if (key.equals("param")) {
                            String valKey = line.substring(6);
                            valKey = valKey.substring(0, valKey.indexOf(61));
                            parameters.put(valKey, line.substring(7 + valKey.length()));
                            continue;
                        }
                }
                data.put(key, line.substring(line.indexOf(61) + 1));
                this.parameters = parameters;
                this.data = data;
            }
        }
    }

    public static URLConnection getCon(URL u) throws Exception {
        if (!u.toString().startsWith("https")) {
            URLConnection conn1 = u.openConnection();
            conn1.addRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
            return conn1;
        }
        return null;
    }

    public static String[] getStrings(URL url) throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getCon(url).getInputStream()));
            ArrayList e = new ArrayList();
            String line = null;

            while ((line = reader.readLine()) != null) {
                e.add(line);
            }

            return (String[]) e.toArray(new String[e.size()]);
        } catch (Exception var4) {
            throw var4;
        }
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public Map<String, String> getData() {
        return data;
        }
    }
