package com.example.maxime.basedijoncenter_mw;

import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.maxime.basedijoncenter_mw.Adapters.LoadPoi;
import com.example.maxime.basedijoncenter_mw.Adapters.PoiListAdapter;
import com.example.maxime.basedijoncenter_mw.Models.PointOfInterest;
import com.google.android.gms.maps.MapFragment;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

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

        new LoadPoi(){
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
            @Override
            protected void onPostExecute(ArrayList<PointOfInterest> pointOfInterests) {
                super.onPostExecute(pointOfInterests);

                if (pointOfInterests != null) {


                    PoiListAdapter adapter = new PoiListAdapter( MainActivity.this, pointOfInterests);
                    listview.setAdapter(adapter);



                    //MapFragment mMapFragment = MapFragment.newInstance();
                    //FragmentTransaction fragmentTransaction =
                    //        getFragmentManager().beginTransaction();
                    //fragmentTransaction.add(R.id.map, mMapFragment);
                    //fragmentTransaction.commit();



                }

            }
        }.execute(url);



    }




}
