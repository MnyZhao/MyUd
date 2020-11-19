package com.mny.popularmovie.utls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class JavaHttpUrl {
    public static String getInfo(String url) {
        InputStream is = null;
        try {
            URL s = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) s.openConnection();
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                return getToString(is);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getToString(InputStream is) throws IOException {
        String result = new String(getByte(is));
        is.close();
        return result;
    }

    public static byte[] getByte(InputStream is) throws IOException {
        if (is == null) {
            return null;
        }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        byte[] bs = new byte[1024 * 50];
        int len = -1;
        while ((len = is.read(bs)) != -1) {
            stream.write(bs, 0, len);
        }
        byte[] result = stream.toByteArray();
        stream.close();
        is.close();
        return result;
    }
}
