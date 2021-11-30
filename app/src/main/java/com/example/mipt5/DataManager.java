package com.example.mipt5;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DataManager {

    public static String getRateFromECB(String currencyCode) throws IOException {
        String rate;
        try (InputStream stream = downloadUrl()) {
            rate = XmlParser.getRateFromECB( stream, currencyCode );
        }
        return rate;
    }

    private static InputStream downloadUrl() throws IOException {
        URL url = new URL( Constants.ECB_URL );
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.connect();
        return conn.getInputStream();
    }
}
