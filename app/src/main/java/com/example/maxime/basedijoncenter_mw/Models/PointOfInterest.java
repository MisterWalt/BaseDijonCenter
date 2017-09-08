package com.example.maxime.basedijoncenter_mw.Models;

import android.util.JsonReader;

import java.io.IOException;

/**
 * Created by Maxime on 08/09/2017.
 */

public class PointOfInterest {

    public String id;
    public String type;
    public String name;
    public Location location;

    public com.example.maxime.basedijoncenter_mw.Models.Location getLocation() {
        return location;
    }

    public void setLocation(com.example.maxime.basedijoncenter_mw.Models.Location location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void buildFromReader(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();

        while (jsonReader.hasNext()){
            String key = jsonReader.nextName();
            if (key.equals("id")){
                this.setId(jsonReader.nextString());
            } else if (key.equals("type")){
                this.setType(jsonReader.nextString());
            } else  if (key.equals("name")){
                this.setName(jsonReader.nextString());
            } else if(key.equals("location")){
                this.location = new Location();
                this.location.buildFromReader(jsonReader);
            }

        }
        jsonReader.endObject();
    }

}
