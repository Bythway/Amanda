package com.example.yeisongomez.amanda.Activities;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.yeisongomez.amanda.Oauth2_chaira.Oauth2Me;
import com.example.yeisongomez.amanda.R;

public class WebViewChairaActivity extends AppCompatActivity {

    private Oauth2Me oauth2Data = new Oauth2Me();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_chaira);

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));

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
