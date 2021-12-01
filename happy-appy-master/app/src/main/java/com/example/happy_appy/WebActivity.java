package com.example.happy_appy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        WebView web = findViewById(R.id.webView);
        String url = "https://hopeforhealingfoundation.org/emotional-first-aid-kit";
        web.loadUrl(url);
    }

}
