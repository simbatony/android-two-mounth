package com.example.simba.myapplication.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.simba.myapplication.R;

/**
 * Created by Simba on 2015/12/17.
 */
public class logindialog {
    AlertDialog alertDialog;
    View mview;
    TextView showMsg;
    ImageView sureBtn;
    ImageView cancleBtn;
    Context context;

    protected void creatDialog(Context context) {

        mview= LayoutInflater.from(context).inflate(R.layout.content_logindialog,null);
     /*   showMsg= (TextView) mview.findViewById(R.id.view_m_alerdialog_msg);
        cancleBtn= (ImageView) mview.findViewById(R.id.view_alerdialog_cancle_btn);
        sureBtn= (ImageView) mview.findViewById(R.id.view_m_alerdialog_sure_btn);
        showMsg.setText(msg);*/
      /*  cancleBtn.setOnClickListener(clickListener);
        sureBtn.setOnClickListener(clickListener);*/

        alertDialog= new AlertDialog.Builder(context).create();
        alertDialog.show();
        Window window =alertDialog.getWindow();
        window.setContentView(mview);

    }



}
