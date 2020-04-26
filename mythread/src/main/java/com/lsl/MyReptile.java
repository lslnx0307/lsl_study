package com.lsl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * customer pa chong lei
 * @author shiliang.li
 * @date 2020/3/26
 */
public class MyReptile {
    public static final String URL = "https://www.jianshu.com/p/0e42fb4334d5";
    public static void main(String[] args) {
        try {
            String str;
            URL url = new URL(URL);
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = url.openStream();
            InputStreamReader reader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            if (bufferedReader.ready()) {
                while ((str = bufferedReader.readLine()) != "") {
                    if (str != null) {
                        System.out.println(str);
                    }

                }
            }
            bufferedReader.close();
            reader.close();
            inputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
