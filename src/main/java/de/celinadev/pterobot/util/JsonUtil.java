package de.celinadev.pterobot.util;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class JsonUtil {

    public static String getJsonFromURL(URL url) {
        String json = null;
        try {
            json = new Scanner(url.openStream(), StandardCharsets.UTF_8).useDelimiter("\\Z").next();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return json;
    }
}
