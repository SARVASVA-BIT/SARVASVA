package com.example.sarvasva.app.fragments.clubProfiles;

import android.content.Intent;
import android.net.Uri;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.sarvasva.R;
import com.example.sarvasva.app.Classes.HorizontalItemModel;
import com.example.sarvasva.app.Classes.HorizontalProductAdaptor;
import com.example.sarvasva.app.activities.MainActivity;
import com.example.sarvasva.app.activities.ViewAllActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class AveonProfile extends Fragment {

    private FrameLayout parentFrameLayout;
    public List<HorizontalItemModel> horizontalList;
    public String aveonGallaryList ;
    private RecyclerView photoGalleryRv;
    private Button viewAllGallery;
    private TextView clubName ,clubAnnouncement , clubAbout , clubPresident , clubJointPresident , clubVicePresident;
    private ImageView clubDp , clubBackground;


    public AveonProfile() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_club_profile, container, false);
        photoGalleryRv = view.findViewById(R.id.photoGalleryRv);
        viewAllGallery = view.findViewById(R.id.viewAllPhotoBtn);
        clubDp = view.findViewById(R.id.club_dp);
        clubAnnouncement = view.findViewById(R.id.club_announcements);
        clubAbout = view.findViewById(R.id.club_about);
        clubJointPresident = view.findViewById(R.id.club_joint_president);
        clubPresident = view.findViewById(R.id.club_president);
        clubVicePresident = view.findViewById(R.id.club_vice_president);
        clubName = view.findViewById(R.id.club_name);
        clubBackground = view.findViewById(R.id.club_cover);



        Glide.with(getContext())
                .load(aveonGallaryList)
                .placeholder(R.drawable.edc_logo)
                .into(clubDp);

        clubName.setText("AVEON");
        clubAbout.setText("Racing Club");
        clubAnnouncement.setText("New REcruiment Soon ");
        clubJointPresident.setText("Mr. M Subhramanayam");
        clubPresident.setText("Monjo");
        clubVicePresident.setText("Rahul");
//        clubDp.setImageResource(R.drawable.aveon_logo);
        clubBackground.setImageResource(R.drawable.aveoncar);

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FirebaseFirestore.getInstance().collection("IMAGES").document("CLUB_GALLERY")
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful())
                {
                  DocumentSnapshot shot = task.getResult();

                  aveonGallaryList = (String) shot.get("aveon_car");



                }
                else
                {
                    Toast.makeText(getContext(), ""+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });





        horizontalList = new ArrayList<>();



//
//        horizontalList.add(new HorizontalItemModel(R.drawable.sign_up));
//        horizontalList.add(new HorizontalItemModel(R.drawable.splash_logo));
//        horizontalList.add(new HorizontalItemModel(R.drawable.forgot_pass_image));
//        horizontalList.add(new HorizontalItemModel(R.drawable.app_icon));
//        horizontalList.add(new HorizontalItemModel(R.drawable.edc_logo));

//        HorizontalProductAdaptor adapter = new HorizontalProductAdaptor(aveonGallaryList);
//
//        LinearLayoutManager manager = new LinearLayoutManager(getContext());
//        manager.setOrientation(RecyclerView.HORIZONTAL);
//        photoGalleryRv.setLayoutManager(manager);
//
//        photoGalleryRv.setAdapter(adapter);
//        adapter.notifyDataSetChanged();


    }
}