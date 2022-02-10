package com.example.kamathinc.weatherman;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    EditText cityName;
    TextView weatherText;

    public void getWeather(View view){
        Downloader downloader = new Downloader();
        try{
            String encodedCityName = URLEncoder.encode(cityName.getText().toString());
            downloader.execute("https://api.openweathermap.org/data/2.5/weather?q="+encodedCityName+"&appid=2c5677fecbb40ee8ae1df7f5784ceca8").get();

            InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE); // for making the keyboard go down

            manager.hideSoftInputFromWindow(cityName.getWindowToken(), 0 );

        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "Could not find weather 😣", Toast.LENGTH_SHORT).show();

            e.printStackTrace();
        }
    }

    public class Downloader extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            String result = "";
            URL url;
            HttpURLConnection connection = null;
            try{

                url = new URL(urls[0]);
                connection = (HttpURLConnection) url.openConnection();
                InputStream in = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);

                int data = reader.read();

                while(data !=-1){
                    char current = (char)data;
                    result += current;
                    data = reader.read();
                }
                return result;
            }catch(Exception e){
                e.printStackTrace();
//                Toast.makeText(getApplicationContext(), "Could not find weather 😣", Toast.LENGTH_SHORT).show();
                return null;
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
//            Log.i("JSON OP", s);
            try{

                JSONObject jsonObject = new JSONObject(s);
                String weatherInfo = jsonObject.getString("weather");
                Log.i("Weather:",weatherInfo);
                JSONArray jsonArray = new JSONArray(weatherInfo);
                String message = "";

                for (int i = 0 ; i < jsonArray.length(); i++){
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    String main = jsonObject1.getString("main");
                    String description = jsonObject1.getString("description");

                    if(!main.equals("") && !description.equals("")){
                        message += main + " : "+description;
                    }
//                    Log.i("Main", jsonObject1.getString("main"));
//                    Log.i("Main", jsonObject1.getString("description"));
                }

                if (!message.equals("")){
                    weatherText.setText(message);
                }

            }catch (Exception e){
                Toast.makeText(getApplicationContext(), "Could not find weather 😣", Toast.LENGTH_SHORT).show();

                e.printStackTrace();
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityName = findViewById(R.id.editText);
        weatherText = findViewById(R.id.textView4);

    }
}
