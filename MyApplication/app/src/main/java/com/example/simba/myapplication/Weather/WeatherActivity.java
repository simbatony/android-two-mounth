package com.example.simba.myapplication.Weather;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.example.simba.myapplication.R;

import com.example.simba.myapplication.Weather.viewpagerintroductin.WeatherintroductionActivity;
import com.example.simba.myapplication.fragment.WeatherexitDialogFragment;
import com.example.simba.myapplication.fragment.weathermainFragment;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;


public class WeatherActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private ArrayList<Itemweather> mylist=new ArrayList<Itemweather>();
    private ArrayList<Leftlistviewclass> mylistleft=new ArrayList<Leftlistviewclass>();

    TextView lastupdateweather;
    DrawerLayout drawerLayout;
    ImageView imageView;
    Button buttonsearch;
    Button buttongps;
    EditText weathercity;
    TextView textViewweather;
    TextView textViewwenduzhi;
    TextView dataweather;
    TextView data2weather;
    ListView listView;
    jsonclass data;
    ListView listViewleft;
    ProgressDialog progress;
    ImageView imageViewopenleftmenu;
    ImageView imageViewrefresh;


    Listviewleftdata Listviewleftdata = new Listviewleftdata();

    Handler mhandler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 10:
                 /*   System.out.println(msg.obj.toString());
                    System.out.println(msg.obj.toString());
                    System.out.println(msg.obj.toString());*/
                    final jsonclass data=(jsonclass)msg.obj;

                    textViewwenduzhi.setText(data.getResult().getToday().getTemperature());
                    textViewweather.setText(data.getResult().getToday().getWeather());
                    dataweather.setText(data.getResult().getToday().getDate_y());
                    data2weather.setText(data.getResult().getToday().getDate_y());
                    lastupdateweather.setText(data.getResult().getSk().getTime());
                    for (int i =0;i<7;i++){

                        Itemweather Itemweather = new Itemweather();
                        Itemweather.setData2weather(data.getResult().getFuture().get(i).getWeek());
                        Itemweather.setDataweather(data.getResult().getFuture().get(i).getDate());
                        Itemweather.setTextViewweather(data.getResult().getFuture().get(i).getWeather());
                        Itemweather.setTextViewwenduzhi(data.getResult().getFuture().get(i).getTemperature());
                        mylist.add(Itemweather);
                    }
                    listView.setAdapter(new ItemweatherAdaper(WeatherActivity.this, mylist));
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //startActivity(new Intent(WeatherActivity.this, WeatherintroductionActivity.class));
                          //  data.getResult().getFuture().get(i).getWeek()
                            Intent mIntent = new Intent(WeatherActivity.this,WeatherdetailActivity.class);
                         // Bundle mBundle = new Bundle();



                            mIntent.putExtra("testIntent",  "123");
                            System.out.println(data.getResult().getFuture().get(position).getDate()+data.getResult().getFuture().get(position).getWeek());
                            mIntent.putExtra("week",  data.getResult().getFuture().get(position).getDate()+data.getResult().getFuture().get(position).getWeek());
                            mIntent.putExtra("Weather",  data.getResult().getFuture().get(position).getWeather());
                            mIntent.putExtra("Wind",   data.getResult().getFuture().get(position).getWind());
                            mIntent.putExtra("Temperature",  data.getResult().getFuture().get(position).getTemperature());

                           // mBundle.putSerializable("data", data.getError_code());
                            mIntent.putExtras(mIntent);

                            startActivity(mIntent);
                        }
                    });
                    break;
                case 20:
                    break;

            }


            super.handleMessage(msg);
        }
    };
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        init();

        getDataInList();
        buttonsearch.setOnClickListener(this);
        buttongps.setOnClickListener(this);
        listViewleft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        startActivity(new Intent(WeatherActivity.this, WeatherActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(WeatherActivity.this, WeatheraboutusActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(WeatherActivity.this,WeatherFeedbackActivity.class));
                        break;
                    case 3:
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        // Create and show the dialog.
                        WeatherexitDialogFragment FireMissilesDialogFragment = new WeatherexitDialogFragment ();
                        FireMissilesDialogFragment.show(ft, "dialog");
                        break;
                }
            }
        });

        SharedPreferences prefs = getSharedPreferences("weatherresponse", MODE_PRIVATE);
        String restoredText = prefs.getString("response", null);
        if(restoredText!=null){
            if (restoredText.length()>100){

                Gson gson = new Gson();
                jsonclass data = gson.fromJson(restoredText,jsonclass.class);
                //发送msg
                Message message = new Message();
                message.what = 10;
                message.obj = data;
                mhandler.sendMessageDelayed(message, 0);
            }
        }


    }

    private void init(){

        buttonsearch = (Button)findViewById(R.id.weathersearch);
        buttongps =(Button)findViewById(R.id.weathergps);
        weathercity = (EditText)findViewById(R.id.weathercity);
        dataweather = (TextView)findViewById(R.id.dataweather);
        data2weather = (TextView)findViewById(R.id.data2weather);
        textViewweather = (TextView)findViewById(R.id.weatherweather);
        textViewwenduzhi = (TextView)findViewById(R.id.wenduzhiweather);
        listView = (ListView)findViewById(R.id.listviewweather);
        listViewleft=(ListView)findViewById(R.id.left_drawerweather);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawerlayoutweather);
        imageViewopenleftmenu=(ImageView)findViewById(R.id.openleftmenu);
        imageViewopenleftmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        listViewleft.setAdapter(new LeftlistviewBaeadaper(WeatherActivity.this, Listviewleftdata.getMylistleft()));

        imageView=(ImageView)findViewById(R.id.imageicon);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WeatherActivity.this,weatherLoginActivity.class));
            }
        });
        lastupdateweather=(TextView)findViewById(R.id.lastupdateweather);
        imageViewrefresh=(ImageView)findViewById(R.id.refreshweather);
        imageViewrefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Animation rotation = AnimationUtils.loadAnimation(WeatherActivity.this, R.layout.rotation);
                    imageViewrefresh.startAnimation(rotation);


                SharedPreferences prefs = getSharedPreferences("weatherresponse", MODE_PRIVATE);
                String restoredText = prefs.getString("response", null);
                if (restoredText!=null){

                    Gson gson = new Gson();
                    jsonclass data = gson.fromJson(restoredText,jsonclass.class);
                    try {
                         volley_post(data.getResult().getToday().getCity());
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    Toast.makeText(getApplication(),"不能获取到当前城市，请重新查询",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.weathersearch:
                if (weathercity.length()==0){
                    Toast.makeText(getApplicationContext(),"城市不能为空",Toast.LENGTH_SHORT).show();
                }else {
                    try {
                        volley_post(weathercity.getText().toString());
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(),"不能联网",Toast.LENGTH_SHORT);
                    }
                }

                break;
            case R.id.weathergps:
                drawerLayout.openDrawer(Gravity.LEFT);
                Toast.makeText(getApplicationContext(),"定位中...",Toast.LENGTH_SHORT).show();
                break;


        }

    }
    private void getDataInList() {
        /*for (int i = 0; i < 3; i++) {
            // Create a new object for each list item
         *//*   Itemweather Itemweather = new Itemweather();
            Itemweather.setData2weather("22222");
            Itemweather.setDataweather("22222");
            Itemweather.setTextViewweather("22222");
            Itemweather.setTextViewwenduzhi("222");
            // Add this object into the ArrayList myList
            mylist.add(Itemweather);*//*
        }*/
    }
    // 利用Volley实现Post请求
    private void volley_post(String city) throws UnsupportedEncodingException {
        progress = ProgressDialog.show(WeatherActivity.this, "加载中","dialog message", true);


        String url2 =  URLEncoder.encode(city, "utf-8");
       // String url =  "http://v.juhe.cn/weather/index?format=2&cityname=%E9%87%8D%E5%BA%86&key=77ad62256511f01cfb4e8d1a75e8940d";

        String url =  "http://v.juhe.cn/weather/index?format=2&cityname="+url2+"&key=77ad62256511f01cfb4e8d1a75e8940d";
        // String url = "http://test.nainiujihua.com/api-login";
        mContext = this;
        mRequestQueue = Volley.newRequestQueue(mContext);
        mStringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("请求结果:" + response);
                        try {
                            JSONObject jsonObj = new JSONObject(response);
                            System.out.println(jsonObj.getString("resultcode"));


                            if (jsonObj.getString("resultcode").toString().equals("202")){
                                System.out.println("不能获取到当前城市");
                                Toast.makeText(getApplicationContext(),"不能获取到当前城市",Toast.LENGTH_SHORT).show();
                                progress.dismiss();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        SharedPreferences.Editor editor = getSharedPreferences("weatherresponse", MODE_PRIVATE).edit();
                        editor.remove("response"); // will delete key key_name3
                        editor.putString("response", response);
                        editor.commit();

                        Gson gson = new Gson();
                        jsonclass data = gson.fromJson(response,jsonclass.class);



                          {

                            Message message = new Message();
                            message.what = 10;
                            message.obj = data;
                            mhandler.sendMessageDelayed(message, 0);
                            //进度条取消
                            progress.dismiss();

                        }


                         //发送msg

                        /*if (data!=null){

                            textViewwenduzhi.setText(data.getResult().getToday().getTemperature());
                            textViewweather.setText(data.getResult().getToday().getWeather());
                            dataweather.setText(data.getResult().getToday().getDate_y());
                            data2weather.setText(data.getResult().getToday().getDate_y());
                            lastupdateweather.setText(data.getResult().getSk().getTime());
                            System.out.println(data.toString());
                            System.out.println(data.getResult().getToday().getTemperature());
                            System.out.println(data.getResult().getToday().getWeather());
                            System.out.println(data.getResult().getToday().getWeek());
                        }*/

                       // System.out.println(d.getResult().getSk().getWind_direction());

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progress.dismiss();
                Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
                System.out.println("请求错误:" + error.toString());
            }
        });
        mStringRequest.setRetryPolicy(new DefaultRetryPolicy(50000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        mRequestQueue.add(mStringRequest);


    }

}
