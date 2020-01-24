package com.example.user.austgroove;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Result extends AppCompatActivity {

    private WebView resultview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        resultview = findViewById(R.id.resultID);

        resultview.loadUrl("http://aust.edu/result/index.htm");
        WebSettings websettings = resultview.getSettings();
        websettings.setJavaScriptEnabled(true);
        resultview.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if(resultview.canGoBack()){
            resultview.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
