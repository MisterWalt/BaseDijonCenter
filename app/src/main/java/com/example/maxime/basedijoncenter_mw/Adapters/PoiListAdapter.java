package com.example.maxime.basedijoncenter_mw.Adapters;

import android.content.Context;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maxime.basedijoncenter_mw.Models.PointOfInterest;
import com.example.maxime.basedijoncenter_mw.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxime on 20/09/2017.
 */

public class PoiListAdapter extends ArrayAdapter<PointOfInterest> {


    public PoiListAdapter(Context context, ArrayList<PointOfInterest> pois) {
        super(context, 0 , pois);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_poi,parent, false);
        }

        PoiViewHolder viewHolder = (PoiViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new PoiViewHolder();
            viewHolder.Name = (TextView) convertView.findViewById(R.id.textViewPoiName);
            viewHolder.Address = (TextView) convertView.findViewById(R.id.textViewPoiAddress);
            viewHolder.Image = (ImageView)  convertView.findViewById(R.id.imageViewPoi);



            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        PointOfInterest poi = getItem(position);

        //il ne reste plus qu'à remplir notre vue




        viewHolder.Name.setText(poi.getName());
        viewHolder.Address.setText(poi.getLocation().getAdress());

        if(poi.getType().equals("CINE"))
        {
            viewHolder.Image.setImageResource(R.drawable.cinema);
        }
        else
        {
            viewHolder.Image.setImageResource(R.drawable.restau);
        }

        viewHolder.Image.setMaxHeight(5);
        viewHolder.Image.setMaxWidth(5);


        return convertView;
    }


    public static class PoiViewHolder{
        public TextView Name;
        public TextView Address;
        public ImageView Image;
    }

}
