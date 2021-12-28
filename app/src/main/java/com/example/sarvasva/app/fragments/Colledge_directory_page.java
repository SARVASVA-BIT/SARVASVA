package com.example.sarvasva.app.fragments;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.sarvasva.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Colledge_directory_page#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Colledge_directory_page extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView topofficial;
    private TextView dean;
    private TextView otherofficial;
    private TextView hod;
    private TextView associatedean ;
    private TextView iqac ;
    private TextView administration;
    private TextView dispensary ;
    private TextView accountpur;
    private TextView examination ;
    private TextView hostelwarden;

    public Colledge_directory_page() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Colledge_directory_page.
     */
    // TODO: Rename and change types and number of parameters
    public static Colledge_directory_page newInstance(String param1, String param2) {
        Colledge_directory_page fragment = new Colledge_directory_page();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_colledge_directory_page, container, false);


        topofficial= (TextView) view.findViewById(R.id.TopOfficial);
        topofficial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new Colledge_Directory_bitmesra());
            }
        });
        dean= (TextView) view.findViewById(R.id.dean);
        dean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new DeanFragment());
            }
        });

        iqac= (TextView) view.findViewById(R.id.iqac);
        iqac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new Directory_IQAC());
            }
        });

        otherofficial= (TextView) view.findViewById(R.id.otherofficials);
        otherofficial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new Other_officials());
            }
        });

        hod= (TextView) view.findViewById(R.id.hod);
        hod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new HOD());
            }
        });

        hostelwarden= (TextView) view.findViewById(R.id.warden);
        hostelwarden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new Hostel_Warden_page());
            }
        });

        dispensary= (TextView) view.findViewById(R.id.dispensary);
        dispensary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new Dispensary());
            }
        });

        accountpur= (TextView) view.findViewById(R.id.accountandpur);
        accountpur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new Account_and_purchase());
            }
        });

        associatedean= (TextView) view.findViewById(R.id.associatedean);
        associatedean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new Associate_Deans());
            }
        });

        administration= (TextView) view.findViewById(R.id.administration);
        administration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new Administration_page());
            }
        });


//        dean.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                changeFragment(new DeanFragment());
//            }
//        });

        return view;
    }
    private void changeFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fui_slide_in_right,R.anim.fui_slide_out_left);
        fragmentTransaction.replace(R.id.main_activity_frame_layout, fragment);
        fragmentTransaction.commit(); }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.TopOfficial:
                changeFragment(new Colledge_Directory_bitmesra());
                break;
            case R.id.dean:
                changeFragment(new DeanFragment());
                break;
        }

    }
}