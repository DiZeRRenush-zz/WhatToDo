package com.example.whattodo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.content.Context;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;


@SuppressLint("ValidFragment")
public class AchFragment extends Fragment {
    private static final String USER_AGENT = "Mozilla/5.0";
    @SuppressLint("ValidFragment")
    public AchFragment(Context context) {
        try {
            String url = "http://m7.zapto.org/api.php?action";
            URL URLobj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) URLobj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Content-length", "0");
            con.setUseCaches(false);
            con.setAllowUserInteraction(false);
            con.setConnectTimeout(30000);
            con.setReadTimeout(30000);
            //con.connect();

            //int responseCode = con.getResponseCode();
            /*


            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
            }
            */
            try {
                Toast itsOk = Toast.makeText(context, "It's okay!", Toast.LENGTH_SHORT);
                itsOk.show();
            } catch (Exception e) {
                Toast warn = Toast.makeText(context,
                        "Определен блок ошибки!", Toast.LENGTH_SHORT);
                warn.show();
            }
        } catch (Exception e) {
            Toast warn = Toast.makeText(context,
                    "Ошибка неизвестна!", Toast.LENGTH_SHORT);
            warn.show();
        }
    }

    public static AchFragment newInstance(Context context) {
        return new AchFragment(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.achievement_activity, container, false);
    }
}