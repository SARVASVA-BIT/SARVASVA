package com.example.sarvasva.app.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.sarvasva.R;
import com.example.sarvasva.app.fragments.clubProfiles.AveonProfile;


public class ClubDirectory extends Fragment implements View.OnClickListener {
    private FrameLayout parentFrameLayout;
    private CardView Card;
    FragmentTransaction fragmentTransaction;



    public ClubDirectory() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_club_directory, container, false);
        Card = (CardView) view.findViewById(R.id.edc);
        Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        changeFragment(new ClubsProfile());
            }
        });


        Card = (CardView) view.findViewById(R.id.aveon);
        Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        changeFragment(new AveonProfile());
             }
        });

        return view;
    }


    private void changeFragment(Fragment fragment) {
        fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fui_slide_in_right,R.anim.fui_slide_out_left);
        fragmentTransaction.replace(R.id.main_activity_frame_layout, fragment);
        fragmentTransaction.addToBackStack(null).commit(); }


    @Override
    public void onClick(View view) {

    }
}
