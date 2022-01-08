package com.example.sarvasva.app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sarvasva.R;

public class Announcements extends Fragment {


    public WebView mWebView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {




        View v=inflater.inflate(R.layout.fragment_announcements, container, false);
        mWebView = (WebView) v.findViewById(R.id.siteAnnouncements);
        mWebView.loadUrl("https://www.bitmesra.ac.in/Show_all_Notices?cid=1");

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());

        return v;
    }
}