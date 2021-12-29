package com.example.sarvasva.app.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.sarvasva.R;
import com.example.sarvasva.app.Classes.HorizontalItemModel;
import com.example.sarvasva.app.Classes.HorizontalProductAdaptor;
import com.example.sarvasva.app.activities.MainActivity;
import com.example.sarvasva.app.activities.ViewAllActivity;

import java.util.ArrayList;
import java.util.List;

public class ClubsProfile extends Fragment {

    private FrameLayout parentFrameLayout;
    public List<HorizontalItemModel> horizontalList;
    private RecyclerView photoGalleryRv;
    private Button viewAllGallery;

    public ClubsProfile() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_club_profile, container, false);
        photoGalleryRv = view.findViewById(R.id.photoGalleryRv);
        viewAllGallery = view.findViewById(R.id.viewAllPhotoBtn);

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        viewAllGallery.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getContext(), ViewAllActivity.class);
//                startActivity(intent);
//                getActivity().finish();
//            }
//        });
//        horizontalList = new ArrayList<>();
//        horizontalList.add(new HorizontalItemModel(R.drawable.app_icon));
//        horizontalList.add(new HorizontalItemModel(R.drawable.sign_up));
//        horizontalList.add(new HorizontalItemModel(R.drawable.forgot_pass_image));
//        horizontalList.add(new HorizontalItemModel(R.drawable.app_icon));
//        horizontalList.add(new HorizontalItemModel(R.drawable.edc_logo));
//
//        HorizontalProductAdaptor adapter = new HorizontalProductAdaptor(horizontalList);

//        LinearLayoutManager manager = new LinearLayoutManager(getContext());
//        manager.setOrientation(RecyclerView.HORIZONTAL);
//        photoGalleryRv.setLayoutManager(manager);
//
//        photoGalleryRv.setAdapter(adapter);
//        adapter.notifyDataSetChanged();


    }
}