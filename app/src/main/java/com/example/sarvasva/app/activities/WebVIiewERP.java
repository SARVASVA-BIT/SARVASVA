package com.example.sarvasva.app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.sarvasva.R;

public class WebVIiewERP extends AppCompatActivity {

    private WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_viiew_erp);


        webview  = (WebView) findViewById(R.id.webviewERP) ;
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("https://www.bitmesra.ac.in/Show_Content_Section?cid=1&pid=365");

        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if(webview.canGoBack()){
            webview.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}