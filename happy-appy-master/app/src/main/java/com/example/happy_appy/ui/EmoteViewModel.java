package com.example.happy_appy.ui;

import android.content.Intent;
import android.view.View;
import android.webkit.WebView;

import androidx.lifecycle.ViewModel;

import com.example.happy_appy.R;
import com.example.happy_appy.WebActivity;



public class EmoteViewModel extends ViewModel {

    // TODO: Implement the ViewModel
    public void loadWebPage(){

        //WebView web = WebView.findViewById(R.id.webView);
        String url = "https://hopeforhealingfoundation.org/emotional-first-aid-kit";
        //web.loadUrl(url);
    }

}
