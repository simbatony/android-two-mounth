package com.example.simba.myapplication.Weather;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.gsm.SmsManager;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.simba.myapplication.R;
import com.example.simba.myapplication.fragment.WeatherexitDialogFragment;


public class WeatherFeedbackActivity extends AppCompatActivity {
    Listviewleftdata Listviewleftdata = new Listviewleftdata();
    ListView listViewleft;
    Button buttonsend;
    EditText editTextfeedback;
    ImageView imageViewopenleftmenu;
    DrawerLayout drawerLayout;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_feedback);

       // listView=(ListView)findViewById(R.id.left_drawerweatherfeedback);
        buttonsend=(Button)findViewById(R.id.buttonsendfeedback);
        editTextfeedback=(EditText)findViewById(R.id.textfeedback);
        initleftmenu();

       /* listView.setAdapter(new LeftlistviewBaeadaper(WeatherFeedbackActivity.this, Listviewleftdata.getMylistleft()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){

                    case 0:
                        startActivity(new Intent(WeatherFeedbackActivity.this, WeatherActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(WeatherFeedbackActivity.this, WeatheraboutusActivity.class));
                        break;
                    case 2:
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        // Create and show the dialog.
                        WeatherexitDialogFragment FireMissilesDialogFragment = new WeatherexitDialogFragment ();
                        FireMissilesDialogFragment.show(ft, "dialog");
                        break;
                    case 3:


                        break;


                }
            }
        });*/
        buttonsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendmessage("123",editTextfeedback.toString());
                Toast.makeText(getApplicationContext(),"感谢您的反馈",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void sendmessage(String phone, String message){

        PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this, WeatherFeedbackActivity.class), 0);

        SmsManager sms = SmsManager.getDefault();

        sms.sendTextMessage(phone, null, message, pi, null);

    }
    public void initleftmenu(){
        listViewleft=(ListView)findViewById(R.id.left_drawerweather);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layoutfeedback);
        imageViewopenleftmenu=(ImageView)findViewById(R.id.openleftmenufeedback);
        imageViewopenleftmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });



        listViewleft.setAdapter(new LeftlistviewBaeadaper(WeatherFeedbackActivity.this, Listviewleftdata.getMylistleft()));
        listViewleft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(WeatherFeedbackActivity.this, WeatherActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(WeatherFeedbackActivity.this, WeatheraboutusActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(WeatherFeedbackActivity.this, WeatherFeedbackActivity.class));
                        break;
                    case 3:
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        // Create and show the dialog.
                        WeatherexitDialogFragment FireMissilesDialogFragment = new WeatherexitDialogFragment();
                        FireMissilesDialogFragment.show(ft, "dialog");
                        break;
                }
            }
        });

        imageView=(ImageView)findViewById(R.id.imageicon);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WeatherFeedbackActivity.this, weatherLoginActivity.class));
            }
        });

    }

}
