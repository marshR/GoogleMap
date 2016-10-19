package com.example.marsh.googlemap;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by marsh on 10/15/16.
 */

public class PlaceListAdapter extends RecyclerView.Adapter<PlaceListAdapter.ViewHolder> {

    private final List<Place> mPlaceList;
    private ListClickElement mListClickElement;
    private PlaceListListener mPlaceListListener;


    PlaceListAdapter(List<Place> placeList, PlaceListListener placeListListener){

        this.mPlaceList = placeList;
        this.mPlaceListListener = placeListListener;
    }

    @Override
    public PlaceListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_info_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Place place = mPlaceList.get(position);
        String name = place.getName();
        double lat = place.getLatitude();
        double lon = place.getLongitude();
        holder.titleTextView.setText(name);
        holder.latitude.setText(Double.toString(lat));
        holder.longitude.setText(Double.toString(lon));

        holder.titleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlaceListListener.onClickPlaceRow(place);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mPlaceList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView ;
        TextView latitude;
        TextView longitude;

        public ViewHolder(View itemView) {
            super(itemView);
        titleTextView = (TextView) itemView.findViewById(R.id.place_title);
            latitude = (TextView) itemView.findViewById(R.id.place_lat);
            longitude = (TextView) itemView.findViewById(R.id.place_lon);


            itemView.findViewById(R.id.place_title);
        }
    }
}
