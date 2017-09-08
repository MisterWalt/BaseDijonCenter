package com.example.maxime.basedijoncenter_mw.Models;

import android.util.JsonReader;

import java.io.IOException;

/**
 * Created by Maxime on 08/09/2017.
 */

public class Location {
    public String adress;
    public String postalCode;
    public Position position;
    public String city;

    public com.example.maxime.basedijoncenter_mw.Models.Position getPosition() {
        return position;
    }

    public void setPosition(com.example.maxime.basedijoncenter_mw.Models.Position position) {
        this.position = position;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }




    public void buildFromReader(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();

        while (jsonReader.hasNext()){
            String key = jsonReader.nextName();
            if (key.equals("adress")){
                this.setAdress(jsonReader.nextString());
            } else if (key.equals("postalCode")){
                this.setPostalCode(jsonReader.nextString());
            }else if (key.equals("city")){
                this.setCity(jsonReader.nextString());
            }else if (key.equals("position")){
                this.position = new Position();
                this.position.buildFromReader(jsonReader);
            }

        }

        jsonReader.endObject();

    }

}
