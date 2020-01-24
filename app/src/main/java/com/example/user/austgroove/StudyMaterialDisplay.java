package com.example.user.austgroove;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class StudyMaterialDisplay extends AppCompatActivity {
    private WebView materialDisplayView;
    private WebSettings webSettings;
    String Semester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_material_display);


        materialDisplayView = findViewById(R.id.materialDisplayID);



        Semester = getIntent().getStringExtra("semester");

        if (Semester.equals("1.1")){

            materialDisplayView.loadUrl("https://drive.google.com/drive/folders/1ea74de-X8G5N-wl1zkM9E4hatSLnoFlR?fbclid=IwAR2w8E_XCukmdh_eBKgwmjX6-n8vfHDdp4cYI13jmeCeDpszlodCqnnD4I8");
            webSettings = materialDisplayView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            materialDisplayView.setWebViewClient(new WebViewClient());
            setTitle("Study Material 1.1");


        }

        if (Semester.equals("1.2")){

            materialDisplayView.loadUrl("https://drive.google.com/drive/folders/1yiKcFbXXLSPOknGmLCwPZn0RKr2M2SpE?fbclid=IwAR2w8E_XCukmdh_eBKgwmjX6-n8vfHDdp4cYI13jmeCeDpszlodCqnnD4I8");
            webSettings = materialDisplayView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            materialDisplayView.setWebViewClient(new WebViewClient());
            setTitle("Study Material 1.2");


        }

        if (Semester.equals("2.1")){

            materialDisplayView.loadUrl("https://drive.google.com/drive/u/0/folders/1WrSdmPQ2_3ZyRpGIL_iNig_PRQzH97uS");
            webSettings = materialDisplayView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            materialDisplayView.setWebViewClient(new WebViewClient());
            setTitle("Study Material 2.1");


        }

        if (Semester.equals("2.2")){

            materialDisplayView.loadUrl("https://drive.google.com/drive/u/0/folders/1GbfFIHa4MI_0dGwpDEk8V6p2i5KoZnVc");
            webSettings = materialDisplayView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            materialDisplayView.setWebViewClient(new WebViewClient());
            setTitle("Study Material 2.2");


        }

        if (Semester.equals("3.1")){

            materialDisplayView.loadUrl("https://drive.google.com/drive/folders/16WoDnLu0eVtKz8KQkZMbE4HjONO_Bi6O?fbclid=IwAR2w8E_XCukmdh_eBKgwmjX6-n8vfHDdp4cYI13jmeCeDpszlodCqnnD4I8");
            webSettings = materialDisplayView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            materialDisplayView.setWebViewClient(new WebViewClient());
            setTitle("Study Material 3.1");


        }

        if (Semester.equals("3.2")){

            materialDisplayView.loadUrl("https://drive.google.com/drive/folders/1Upl6ab1AladDPXLnjjShoVRjtZ7X-qZo?fbclid=IwAR2w8E_XCukmdh_eBKgwmjX6-n8vfHDdp4cYI13jmeCeDpszlodCqnnD4I8");
            webSettings = materialDisplayView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            materialDisplayView.setWebViewClient(new WebViewClient());
            setTitle("Study Material 3.2");


        }

        if (Semester.equals("4.1")){

            materialDisplayView.loadUrl("https://drive.google.com/drive/folders/1hzOPko7n_YNxZm1mBFsroFNbt4uIrt5l?fbclid=IwAR2w8E_XCukmdh_eBKgwmjX6-n8vfHDdp4cYI13jmeCeDpszlodCqnnD4I8");
            webSettings = materialDisplayView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            materialDisplayView.setWebViewClient(new WebViewClient());
            setTitle("Study Material 4.1");


        }

        if (Semester.equals("4.2")){

            materialDisplayView.loadUrl("https://drive.google.com/drive/folders/1SpzSKPq3F4hfxQVMS2tKO79aOIwx6mRE?fbclid=IwAR2w8E_XCukmdh_eBKgwmjX6-n8vfHDdp4cYI13jmeCeDpszlodCqnnD4I8");
            webSettings = materialDisplayView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            materialDisplayView.setWebViewClient(new WebViewClient());
            setTitle("Study Material 4.2");


        }
    }
}
