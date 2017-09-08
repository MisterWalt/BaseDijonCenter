package com.example.maxime.basedijoncenter_mw.Adapters;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.util.JsonReader;

import com.example.maxime.basedijoncenter_mw.Models.PointOfInterest;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Maxime on 08/09/2017.
 */

public class PoiAdapter extends AsyncTask<URL, Void, ArrayList<PointOfInterest>>{

    @Override
    protected ArrayList<PointOfInterest> doInBackground(URL... params) {
        ArrayList<PointOfInterest> list = null;
        HttpsURLConnection myConnection = null;
        try {
            myConnection = (HttpsURLConnection) params[0].openConnection();

            InputStream inputStream = myConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");

            list = new ArrayList<PointOfInterest>();

            JsonReader jsonReader = new JsonReader(inputStreamReader);

            jsonReader.beginArray(); // Start processing the JSON object
            while (jsonReader.hasNext()) { // Loop through all keys
                PointOfInterest poi = new PointOfInterest();
                poi.buildFromReader(jsonReader);
                list.add(poi);
            }
            jsonReader.endArray();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

}
