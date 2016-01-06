package com.example.simba.myapplication.dialog;

import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.simba.myapplication.R;
import com.example.simba.myapplication.recycleview.MainActivity;

public class logindialogActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logindialog);

    /*    //方法1
        logindialog logindialog=new logindialog();
        logindialog.creatDialog(logindialogActivity.this);
*/
        //方法2
      /*  ProgressDialog dialog;
        dialog= new ProgressDialog(logindialogActivity.this);
        dialog.setTitle("加载中");
        dialog.show();
        */
        //方法3
        Dialog mLoading;

        mLoading = createLoadingDialog(this);

        mLoading.show();
      /*  //notifycation
        notification();*/


    }
    public Dialog createLoadingDialog(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.content_logindialog, null);        // 得到加载view
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view);  // 加载布局
        ImageView spaceshipImage = (ImageView) v.findViewById(R.id.img);
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(context, R.xml.loading_animation); // 加载动画
        spaceshipImage.startAnimation(hyperspaceJumpAnimation);             // 使用ImageView显示动画
        Dialog loadingDialog = new Dialog(context, R.style.loading_dialog); // 创建自定义样式dialog

        //loadingDialog.setCancelable(false);// 不可以用"返回键"取消
        loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        return loadingDialog;
    }
    public void notification(){

        Bitmap btm = BitmapFactory.decodeResource(getResources(),
                R.drawable.images);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                logindialogActivity.this)
                .setSmallIcon(R.drawable.images)
                .setContentTitle("5 new message")
                .setContentText("twain@android.com");
        mBuilder.setTicker("New message");//第一次提示消息的时候显示在通知栏上
        mBuilder.setNumber(12);
        mBuilder.setLargeIcon(btm);
        mBuilder.setAutoCancel(true);//自己维护通知的消失

        Intent resultIntent = new Intent(this, logindialogActivity.class);

        // Because clicking the notification opens a new ("special") activity, there's
        // no need to create an artificial back stack.
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        this,
                        0,
                        resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);

        // Sets an ID for the notification
        int mNotificationId = 001;
        // Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr =
        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }

}
