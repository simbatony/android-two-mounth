package com.example.simba.myapplication.getgps;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.simba.myapplication.R;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class getgpsActivity extends AppCompatActivity {
    private LocationManager locationManager;
    String TAG="12";
    public  LocationManager lm;
    Button button;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getgps);
        /*WifiManager wm = (WifiManager) getSystemService(WIFI_SERVICE);
        String ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
*/

        WifiManager wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);


        WifiInfo wifiInfo = wifiManager.getConnectionInfo();


        int ipAddress = wifiInfo.getIpAddress();

        System.out.println("地址为1"+ipAddress);
        System.out.println("地址为2"+getLocalIpAddress());
        button=(Button)findViewById(R.id.buttongetgps);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getgps();
            }
        });
        getgps();


    }

    public String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException ex) {
            Log.e(TAG, ex.toString());
        }
        return null;
    }
    public void getgps(){

        /*模拟器运行出现一些问题
        * 不能够获取到gps
        * */

        LocationManager locMan = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location loc = locMan.getLastKnownLocation(LocationManager.GPS_PROVIDER);
      if (loc != null) {
           Double lat = loc.getLatitude();
            Log.d(TAG, "latitude: !!!!!!!!!!!!!" + lat);
            System.out.println(lat+"latitude: !!!!!!!!!!!!!");
            Double lng = loc.getLongitude();
            Log.d(TAG, "longitude:!!!!!!!!!!!!! " + lng);
            System.out.println(lng + "latitude: !!!!!!!!!!!!!");
        }
    }






}


