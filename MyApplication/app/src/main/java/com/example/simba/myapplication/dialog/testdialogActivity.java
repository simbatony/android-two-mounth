package com.example.simba.myapplication.dialog;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.example.simba.myapplication.R;
import com.plattysoft.leonids.ParticleSystem;

import me.drakeet.materialdialog.MaterialDialog;

public class testdialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testdialog);
        Button button = (Button) findViewById(R.id.button_testdialog);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
 /*             // new FireMissilesDialogFragment().show(null,null);
              //  dialogone();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                // Create and show the dialog.
                FireMissilesDialogFragment FireMissilesDialogFragment = new FireMissilesDialogFragment ();
                FireMissilesDialogFragment.show(ft, "退出");*/
                final ProgressDialog progress;


                progress = ProgressDialog.show(testdialogActivity.this, "dialog title",
                        "dialog message", true);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                            progress.dismiss();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();


            }
        });
    }
    private void dialogone(){


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        testdialogActivity.this.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
        AlertDialog alert = builder.create();
    }
    public void dialogtwo(){

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Create and show the dialog.
        FireMissilesDialogFragment FireMissilesDialogFragment = new FireMissilesDialogFragment ();
        FireMissilesDialogFragment.show(ft, "退出");
    }
    public void materialdialogtwo(){

        final MaterialDialog mMaterialDialog = new MaterialDialog(testdialogActivity.this);
        mMaterialDialog.setTitle("MaterialDialog");
        mMaterialDialog.setMessage("Hello world!");
        mMaterialDialog.setPositiveButton("OK", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMaterialDialog.dismiss();

            }
        });
        mMaterialDialog.setNegativeButton("CANCEL", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMaterialDialog.dismiss();

            }
        });
        mMaterialDialog.show();
    }

}
