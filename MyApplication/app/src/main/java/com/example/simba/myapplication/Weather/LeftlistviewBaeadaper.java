package com.example.simba.myapplication.Weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.simba.myapplication.R;

import java.util.ArrayList;

/**
 * Created by Simba on 2015/12/04.
 */
public class LeftlistviewBaeadaper extends BaseAdapter {
    ArrayList<Leftlistviewclass> myitem = new ArrayList<Leftlistviewclass>();
    LayoutInflater inflater;
    Context context;
    public LeftlistviewBaeadaper(Context context,ArrayList<Leftlistviewclass> myitem){
        this.myitem = myitem;
        this.context = context;
        inflater = LayoutInflater.from(this.context);

    }
    @Override
    public int getCount() {
        return myitem.size();
    }

    @Override
    public Leftlistviewclass getItem(int position) {
        return myitem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.weatherleftlayout,parent,false);
            myViewHolder = new MyViewHolder(convertView);
            convertView.setTag(myViewHolder);
        }else {
            myViewHolder = (MyViewHolder)convertView.getTag();
        }
        Leftlistviewclass currentItenweather = getItem(position);
        myViewHolder.title.setText(currentItenweather.getTitle());
        myViewHolder.imageView.setImageResource(currentItenweather.getImage());


        return convertView;
    }
    private class MyViewHolder {
        TextView title ;
        ImageView imageView;

        public MyViewHolder(View item) {
            title = (TextView)item.findViewById(R.id.textviewleftweather);
            imageView = (ImageView)item.findViewById(R.id.imageleftweather);

        }
    }
}
