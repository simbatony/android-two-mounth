package com.example.simba.myapplication.webview;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.simba.myapplication.R;
import com.lidroid.xutils.view.annotation.ViewInject;

public class webviewchartsActivity extends Activity {

  //  @ViewInject(R.id.webviewchart)
    private WebView webView;
    ProgressDialog progress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webviewcharts);
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
/*        progress = new ProgressDialog(this);
        progress.show();*/

        initwebview();



    }


    protected void initwebview(){
        webView = (WebView)findViewById(R.id.webviewchart);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);

       webView.setBackgroundColor(0);
        webView.setBackgroundResource(R.drawable.webviewbackground);
        webView.getBackground().setAlpha(50);

        webView.setOverScrollMode(View.OVER_SCROLL_NEVER);

      //  webView.getSettings().setLoadWithOverviewMode(true);

        webView.setHorizontalScrollBarEnabled(false);
        webView.setVerticalScrollBarEnabled(false);


        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

      //  webView.setInitialScale(25);


      /*  webView.setInitialScale(107);
        webView.getSettings().setUseWideViewPort(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
*/

     /*   webView.setInitialScale(107);
        webView.getSettings().setUseWideViewPort(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);*/


        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

        });
        webView.loadUrl("https://test.nainiujihua.com/apidata-three_line");

    }

}
