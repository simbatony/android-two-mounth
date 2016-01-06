package com.example.simba.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class MyBaseAdapter extends BaseAdapter {

    ArrayList<ListData> myList = new ArrayList<ListData>();
    LayoutInflater inflater;
    Context context;


    public MyBaseAdapter(Context context, ArrayList<ListData> myList) {
        this.myList = myList;
        this.context = context;
        mQueue = Volley.newRequestQueue(context);
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return 400;
    }

    @Override
    public ListData getItem(int position) {
        return myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        MyViewHolder mViewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_iteml, parent, false);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

      /*  ListData currentListData = getItem(position);

        mViewHolder.tvTitle.setText(currentListData.getTitle());
        mViewHolder.tvDesc.setText(currentListData.getDescription());*/
        mViewHolder.tvTitle.setText("xiaoming");
        mViewHolder.tvDesc.setText("xiaohong");
        // mViewHolder.ivIcon.setImageResource(currentListData.getImgResId());
       // ImageLoaderloadimage(mViewHolder.ivIcon, imageurl.strings[imageurl.i]);
        imageurl.i=imageurl.i+1;
         if ( imageurl.i==430)
         {
             imageurl.i=0;
         }

        BitmapLruCache BitmapLruCache = new BitmapLruCache();
        mimageLoader=new ImageLoader(mQueue,BitmapLruCache);
        ImageLoader.ImageListener listener = ImageLoader.getImageListener(mViewHolder.ivIcon,R.drawable.ic_drawer,R.drawable.button);
        mimageLoader.get(imageurl.strings[imageurl.i],listener,100,100);

        System.out.println("imageurl.i"+imageurl.i);
        mViewHolder.ivIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("点击了图片" + position);
            }
        });
        return convertView;
    }

    private class MyViewHolder {
        TextView tvTitle, tvDesc;
        ImageView ivIcon;

        public MyViewHolder(View item) {
            tvTitle = (TextView) item.findViewById(R.id.tvTitle);
            tvDesc = (TextView) item.findViewById(R.id.tvDesc);
            ivIcon = (ImageView) item.findViewById(R.id.ivIcon);
        }
    }
    private RequestQueue mQueue;
    private  ImageLoader mimageLoader;
    private void  ImageLoaderloadimage(ImageView imageView,String string){
        mQueue = Volley.newRequestQueue(context);
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
       // imageLoader.get("https://test.nainiujihua.com/public/user/avatar/40910/80f20f2f1a75149449894c69f6087d65.jpg",listener,200,200);
        imageLoader.get(string,listener,200,200);
        System.out.println("ImageLoaderloadimage()");
    }
}