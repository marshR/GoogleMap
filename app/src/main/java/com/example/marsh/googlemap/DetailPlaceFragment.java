package com.example.marsh.googlemap;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class DetailPlaceFragment extends Fragment {
    private Place mPlace;
    public int raiting = 0;

    public DetailPlaceFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPlace = getActivity().getIntent().getParcelableExtra(MapsActivity.PLACE_EXTRA_KEY);

    }

    public Place getmPlace() {
        return mPlace;
    }

    public void setmPlace(Place mPlace) {
        this.mPlace = mPlace;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_detail_place, container, false);

        ImageView placeImageView = (ImageView) v.findViewById(R.id.place_imageview);
        TextView placeNameTextView = (TextView) v.findViewById(R.id.place_name_textview);
        TextView placeRankingTextView = (TextView) v.findViewById(R.id.place_rank_textview);
        FloatingActionButton mapButton = (FloatingActionButton) v.findViewById(R.id.map_button);
        // ****RatingBar placeRatingBar = (RatingBar) v.findViewById(((int) R.id.place_ranking_attribute));

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) v.findViewById(R.id.collapsing_toolbar);

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapsActivity.start(getActivity(), mPlace);
            }
        });

        Picasso.with(getActivity()).load(mPlace.getImageUrl()).into(placeImageView);
        placeNameTextView.setText(mPlace.getName());
        placeRankingTextView.setText(String.valueOf(mPlace.getRanking()));



        return v;
    }
}
