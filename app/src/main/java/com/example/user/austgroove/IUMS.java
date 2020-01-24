package com.example.user.austgroove;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class IUMS extends AppCompatActivity {

    private WebView iums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iums);


        iums = findViewById(R.id.iumswebViewID);

        iums.loadUrl("https://iums.aust.edu");
        WebSettings websettings = iums.getSettings();
        websettings.setJavaScriptEnabled(true);
        iums.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if(iums.canGoBack()){
            iums.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
