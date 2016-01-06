package com.example.simba.myapplication.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.example.simba.myapplication.R;

import java.util.Calendar;

public class webviewActivity extends AppCompatActivity {
    private Context context;
    private WebView webView;
    private ImageView imageView ;
    //private View v;
    /*主要是图片显示以及webview 的简单操作*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        webView = (WebView)findViewById(R.id.webviewactivity);
        imageView = (ImageView)findViewById(R.id.imageviewwebview);
        context=this;
        ImageLoaderloadimage();

        initwebview();
        gettime();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                webView.goBack();
                ImageRequestloagimage();
            }
        });
    }
    private void ImageRequestloagimage(){
        RequestQueue mQueue = Volley.newRequestQueue(context);
        ImageRequest imageRequest = new ImageRequest(
                "https://test.nainiujihua.com/public/user/avatar/40910/80f20f2f1a75149449894c69f6087d65.jpg",
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        imageView.setImageBitmap(response);
                        System.out.println("huoqudaotupianle ");
                    }
                }, 100, 100, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                imageView.setImageResource(R.drawable.ic_drawer);
            }
        });
        mQueue.add(imageRequest);
        System.out.println(" ImageRequestloagimage()");

    }
    private void  ImageLoaderloadimage(){
        RequestQueue mQueue = Volley.newRequestQueue(context);
        ImageLoader imageLoader = new ImageLoader(mQueue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String url) {
                return null;
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {

            }
        });
        ImageLoader.ImageListener listener =ImageLoader.getImageListener(imageView,R.drawable.content_music,R.mipmap.ic_launcher);
        imageLoader.get("https://test.nainiujihua.com/public/user/avatar/40910/80f20f2f1a75149449894c69f6087d65.jpg",listener,200,200);
        System.out.println("ImageLoaderloadimage()");
    }
    public void initwebview(){
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;

            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setSaveEnabled(false);
       // v= LayoutInflater.from(this).inflate(R.layout.content_logindialog,null);

//        graphWebView.setInitialScale(107);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        webView.getSettings().setSupportZoom(false);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.loadUrl("http://www.baidu.com/");
    }
    public void gettime(){

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MINUTE);
        int day = c.get(Calendar.HOUR_OF_DAY);
        System.out.println("获取到的时间为  year:"+year+"month:"+month+"day:"+day);
    }


}
