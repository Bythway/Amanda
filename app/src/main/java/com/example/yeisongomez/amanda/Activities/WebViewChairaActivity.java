package com.example.yeisongomez.amanda.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.yeisongomez.amanda.Oauth2_chaira.Oauth2Me;
import com.example.yeisongomez.amanda.R;

public class WebViewChairaActivity extends AppCompatActivity {

    private Oauth2Me oauth2Data = new Oauth2Me();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_chaira);

        WebView webview = (WebView) findViewById(R.id.webview_chaira);
        webview.getSettings().setJavaScriptEnabled(true);

        webview.loadUrl(oauth2Data.getUrlAuthorizationUser());

        webview.setWebViewClient(new WebViewClient(){
            public boolean shouldOverriceUrlLoading(WebView view, String url){
                return false;
            }
        });
    }
}
