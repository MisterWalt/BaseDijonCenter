package com.example.maxime.basedijoncenter_mw.Models;

import android.util.JsonReader;

import java.io.IOException;

/**
 * Created by Maxime on 08/09/2017.
 */

public class Position {
    public double getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public double lat;
    public double lon;



    public void buildFromReader(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();

        while (jsonReader.hasNext()){
            String key = jsonReader.nextName();
            if (key.equals("lat")){
                this.setLat((float) jsonReader.nextDouble());
            } else if (key.equals("lon")){
                this.setLon((float) jsonReader.nextDouble());
            }

        }

        jsonReader.endObject();
    }
}
