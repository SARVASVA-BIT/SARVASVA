package com.example.sarvasva.app.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sarvasva.R;

public class aboutus extends Fragment {

    TextView rsmail;
    TextView srmail;
    TextView aumail;
    ImageView rsinsta;
    ImageView srinsta;
    ImageView auinsta;
    ImageView rslkdin;
    ImageView srlkdin;
    ImageView aulkdin;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_aboutus, container, false);
        rsmail = (TextView) view.findViewById(R.id.rs_mail);
        srmail = (TextView) view.findViewById(R.id.sr_mail);
        aumail = (TextView) view.findViewById(R.id.au_mail);
        rsinsta = (ImageView) view.findViewById(R.id.rsinsta);
        srinsta = (ImageView) view.findViewById(R.id.srinsta);
        auinsta = (ImageView) view.findViewById(R.id.auinsta);
        rslkdin = (ImageView) view.findViewById(R.id.rslkdin);
        srlkdin = (ImageView) view.findViewById(R.id.srlkdin);
        aulkdin = (ImageView) view.findViewById(R.id.aulkdin);
        rsmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "btech10080.20@bitmesra.ac.in" });
                startActivity(Intent.createChooser(intent, ""));
            }
        });
        srmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "btech10373.20@bitmesra.ac.in" });
                startActivity(Intent.createChooser(intent, ""));
            }
        });
        aumail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "btech10100.20@bitmesra.ac.in" });
                startActivity(Intent.createChooser(intent, ""));
            }
        });

        rsinsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.instagram.com/rahul_srivastava._/");
            }
        });
        rslkdin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.linkedin.com/in/rahul-srivastava-44b54a1a1/");
            }
        });

        srinsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.instagram.com/sranjan21/");
            }
        });
        srlkdin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.linkedin.com/in/sudhanshu-ranjan-a372b11bb/");
            }
        });

        auinsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.instagram.com/aryankupadhyay/");
            }
        });
        aulkdin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.linkedin.com/in/aryank-upadhyay-6311641b9/");
            }
        });
        return view;
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}