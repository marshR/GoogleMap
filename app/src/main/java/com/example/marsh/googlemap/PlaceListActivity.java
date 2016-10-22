package com.example.marsh.googlemap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.marsh.googlemap.adapter.PlaceListAdapter;
import com.example.marsh.googlemap.retrofit.PlaceService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlaceListActivity extends AppCompatActivity implements PlaceListListener, Callback<Places> {

    RecyclerView mPlaceListRecycleView;
    private LinearLayoutManager mLayoutManager;
    private PlaceListAdapter mAdapter;
    private List<Place> mPlaceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_list);
        fillPlaceList();

        setPlacesList();
    }

    private void setPlacesList() {
        mPlaceListRecycleView = (RecyclerView) findViewById(R.id.place_list);

        mLayoutManager = new LinearLayoutManager(this);

        mPlaceListRecycleView.setLayoutManager(mLayoutManager);


        mAdapter = new PlaceListAdapter(mPlaceList, this);
        mPlaceListRecycleView.setAdapter(mAdapter);

    }

    private void  fillPlaceList() {
        mPlaceList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://demo2355296.mockable.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PlaceService service = retrofit.create(PlaceService.class);

        Call<Places> call = service.getPlaces();
        call.enqueue(this);


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

    @Override
    public void onResponse(Call<Places> call, Response<Places> response) {
        mPlaceList = response.body().places;
        setPlacesList();
    }

    @Override
    public void onFailure(Call<Places> call, Throwable t) {
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_LONG).show();
    }
}
