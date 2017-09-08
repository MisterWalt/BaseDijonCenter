package com.example.maxime.basedijoncenter_mw;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.maxime.basedijoncenter_mw.Adapters.PoiAdapter;
import com.example.maxime.basedijoncenter_mw.Models.PointOfInterest;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    public ArrayList<PointOfInterest> listPoi;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.listview = (ListView) findViewById(R.id.lstPoi);
        URL url = null;
        try {
            url = new URL("https://my-json-server.typicode.com/lpotherat/pois/pois/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        new PoiAdapter(){
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
            @Override
            protected void onPostExecute(ArrayList<PointOfInterest> pointOfInterests) {
                super.onPostExecute(pointOfInterests);

                if (pointOfInterests != null) {
                    ArrayAdapter adapter = new ArrayAdapter<PointOfInterest>(MainActivity.this, android.R.layout.simple_list_item_1, pointOfInterests);
                    listview.setAdapter(adapter);
                }

            }
        }.execute(url);



    }
}
