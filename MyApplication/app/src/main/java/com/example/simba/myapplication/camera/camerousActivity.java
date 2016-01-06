package com.example.simba.myapplication.camera;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.simba.myapplication.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class camerousActivity extends AppCompatActivity {

    private Button buttonopencamerous;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private Bitmap bitmap;
    private ImageView imageView;
   // Intent intent;
    String FILE_PATH="/sdcard/syscamera.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camerous);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        buttonopencamerous=(Button)findViewById(R.id.buttonopencamerous);
        imageView=(ImageView)findViewById(R.id.imageviewcamerous);
        buttonopencamerous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectimage();
            }
        });
    /*    bitmap = getLoacalBitmap(FILE_PATH);
        imageView.setImageBitmap(bitmap);*/

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                takepicture();
            }
        });
        Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                bitmap = getLoacalBitmap(FILE_PATH);
                imageView.setImageBitmap(bitmap);
            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println(requestCode+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+requestCode);
       /* if (data==null){
            return;
        }*/
        Uri uri;
        ContentResolver cr = this.getContentResolver();
        Bitmap bitmap = null;
        switch (requestCode){
            case selectimage:
            {
              if (data==null){
                  return;
              }
                uri = data.getData();
                System.out.println("eeeeeeeeeeeeeeeeeeeeeee");
                try {
                    bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                    System.out.println("选择的图片");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                //  bitmap =(Bitmap)extras.get("data");
                imageView.setImageBitmap(bitmap);
                break;
            }


            case googleimage:
            {
                Intent intent = getIntent();
                //System.out.println("ccccccccccccccccccc");
                uri = intent.getParcelableExtra(MediaStore.EXTRA_OUTPUT);
                try {
                    bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                    System.out.println("拍到的图片");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                //  bitmap =(Bitmap)extras.get("data");
                imageView.setImageBitmap(bitmap);
                break;
            }

            case takepicture:
                //方法1
                /*System.out.println("这里执行了！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
                bitmap = getLoacalBitmap(FILE_PATH);
                imageView.setImageBitmap(bitmap);
                break;*/
            //方法2
                bitmap = (Bitmap)data.getExtras().get("data");
                imageView.setImageBitmap(bitmap);
                break;

             /*   File file = new File(FILE_PATH);
                uri = Uri.fromFile(file);
                try {
                    bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                imageView.setImageBitmap(bitmap);*/


                /*if (resultCode == RESULT_OK) {
                    // Image captured and saved to fileUri specified in the Intent
                    Toast.makeText(this, "Image saved to:\n" +
                            data.getData(), Toast.LENGTH_LONG).show();

                    fileUri=getIntent().getParcelableExtra(MediaStore.EXTRA_OUTPUT);
                    try {
                        bitmap = BitmapFactory.decodeStream(cr.openInputStream(fileUri));
                        System.out.println("选择的图片");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    //  bitmap =(Bitmap)extras.get("data");
                    imageView.setImageBitmap(bitmap);


                } else if (resultCode == RESULT_CANCELED) {
                    System.out.println("选择的图片22");
                    // User cancelled the image capture
                } else {
                    System.out.println("选择的图片33");
                    // Image capture failed, advise user
                }
                System.out.println("选择的图片5555");
                break;*/


        }


    }
        protected void selectimage(){
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
           /* intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);*/
            startActivityForResult(intent, selectimage);
        }
        protected void takepicture(){
            Intent intent = new Intent();
            // 指定开启系统相机的Action
            intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            // 根据文件地址创建文件
            File file = new File(FILE_PATH);
            if (file.exists()) {
                file.delete();
            }
            // 把文件地址转换成Uri格式
            Uri uri = Uri.fromFile(file);
            // 设置系统相机拍摄照片完成后图片文件的存放地址
            //方法2 注释掉intent.putextra，方法1  不用注释
          //  intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            startActivityForResult(intent, takepicture);

        }
        public void googleimage(){
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


            Uri imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),"image.jpg"));
            //指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);

        /*    fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE); // create a file to save the image
            intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name
*/
            // start the image capture Intent
            startActivityForResult(intent, googleimage);


        }

    private static final int CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE = 200;
    private static Uri fileUri;
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;
    public static final int selectimage = 5;
    public static final int takepicture = 6;
    public static final int googleimage = 7;


    private static Uri getOutputMediaFileUri(int type){
        return Uri.fromFile(getOutputMediaFile(type));
    }

    /** Create a File for saving an image or video */
    private static File getOutputMediaFile(int type){
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "MyCameraApp");
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(12587));
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE){
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_"+ timeStamp + ".jpg");
        } else if(type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "VID_"+ timeStamp + ".mp4");
        } else {
            return null;
        }

        return mediaFile;
    }
    public static Bitmap getLoacalBitmap(String url) {
        try {
            FileInputStream fis = new FileInputStream(url);
            return BitmapFactory.decodeStream(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
