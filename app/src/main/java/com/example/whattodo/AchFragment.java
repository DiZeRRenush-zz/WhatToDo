package com.example.whattodo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


public class AchFragment extends Fragment {
    private TextView mTextMessage;
    private View achView;

    public AchFragment (){};

    public static AchFragment newInstance() {
        return new AchFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        achView = inflater.inflate(R.layout.achievement_activity, container, false);
        mTextMessage = achView.findViewById(R.id.tv_home);
        Log.d("AsyncLog", "GOING TO ASYNC!");
        myAsync task = new myAsync();
        task.execute();
        return achView;
    }

    class myAsync extends AsyncTask<String, String, String> {

        public static final String REQUEST_URL = "http://m7.zapto.org/api/api.php?read";
        public static final int READ_TIMEOUT = 15000;
        public static final int CONNECTION_TIMEOUT = 15000;
        private JSONObject jsonObj = null;
        private String result;
        private TextView curPage = (TextView) achView.findViewById(R.id.tv_home);

        protected void onPreExecute(String myString) {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... urls) {
            try {
                URL url = new URL(REQUEST_URL);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setReadTimeout(READ_TIMEOUT);
                con.setConnectTimeout(CONNECTION_TIMEOUT);

                int statusCode = con.getResponseCode();
                if (statusCode ==  200) {
                    Log.d("AsyncLog", "200");
                    String inputLine;
                    //Connect to our url
                    con.connect();
                    //Create a new InputStreamReader
                    InputStreamReader streamReader = new InputStreamReader(con.getInputStream());
                    //Create a new buffered reader and String Builder
                    BufferedReader reader = new BufferedReader(streamReader);
                    StringBuilder stringBuilder = new StringBuilder();
                    //Check if the line we are reading is not null
                    while((inputLine = reader.readLine()) != null){
                        stringBuilder.append(inputLine);
                    }
                    //Close our InputStream and Buffered reader
                    reader.close();
                    streamReader.close();
                    //Set our result equal to our stringBuilder
                    result = stringBuilder.toString();
                    //jsonObj = new JSONObject(result);
                    Log.d("AsyncLog", result);
                    //Log.d("AsyncLog", jsonObj.getString("msg"));
                } else {
                    Log.d("AsyncLog", "Not 200!");
                }

                con.disconnect();
            } catch (NullPointerException e) {
                Log.d("AsyncLog", "NullPointerException");
            } catch (RuntimeException e) {
                Log.d("AsyncLog", "RuntimeException");
            } catch (MalformedURLException e) {
                Log.d("AsyncLog", "MalformedURLException");
            } catch (ProtocolException e) {
                Log.d("AsyncLog", "ProtocolException");
            } catch (IOException e) {
                Log.d("AsyncLog", "IOException");
            } catch (Exception e) {
                Log.d("AsyncLog", "Idk what is it");
            }
            return result;
        }

        protected void onProgressUpdate(String value) {
            super.onProgressUpdate(value);
            mTextMessage.setText(value);
        }

        protected void onPostExecute(String value) {
            super.onPostExecute(value);
            mTextMessage.setText(value);
        }

        protected void onPostExecute(Boolean result) {
            //return jsonObj;
        }
    }
}
