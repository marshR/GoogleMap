package com.example.marsh.googlemap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PlaceListActivity extends AppCompatActivity implements PlaceListListener {

    RecyclerView mPlaceListRecycleView;
    private LinearLayoutManager mLayoutManager;
    private PlaceListAdapter mAdapter;
    private List<Place> mPlaceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_list);

        mPlaceListRecycleView = (RecyclerView) findViewById(R.id.place_list);

        mLayoutManager = new LinearLayoutManager(this);

        mPlaceListRecycleView.setLayoutManager(mLayoutManager);

        generatePlaceList();

        mAdapter = new PlaceListAdapter(mPlaceList, this);
        mPlaceListRecycleView.setAdapter(mAdapter);

        MapsActivity.start(this, new Place ("Lugar", 29.097508, -111.022250));
    }

    private void generatePlaceList() {
        mPlaceList = new ArrayList<>();
        mPlaceList.add(new Place("casa", 29.073823, -110.980698));
        mPlaceList.add(new Place("escuela", 21, 40));


    }

    @Override
    public void onClickPlaceRow(Place place) {
        MapsActivity.start(this, place);
    }
}
