package com.example.user.austgroove;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ClassRoutine extends AppCompatActivity {

    private WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_routine);
        // https://drive.google.com/open?id=1Pn6r9wRKsxNN6Og_b5XaKjR1OjSp6E8B

        webview = findViewById(R.id.academicCalenderwebViewID);

        webview.loadUrl("https://drive.google.com/open?id=1Pn6r9wRKsxNN6Og_b5XaKjR1OjSp6E8B");
        WebSettings websettings = webview.getSettings();
        websettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if(webview.canGoBack()){
            webview.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
