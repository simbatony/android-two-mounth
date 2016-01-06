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
 * Created by Simba on 2015/12/03.
 */
public class ItemweatherAdaper extends BaseAdapter {
    ArrayList<Itemweather> myitem = new ArrayList<Itemweather>();
    LayoutInflater inflater;
    Context context;
    public ItemweatherAdaper(Context context,ArrayList<Itemweather> myitem){
        this.myitem = myitem;
        this.context = context;
        inflater = LayoutInflater.from(this.context);

    }
    @Override
    public int getCount() {
        return myitem.size();
    }

    @Override
    public Itemweather getItem(int position) {
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
            convertView = inflater.inflate(R.layout.layoutweatheritem,parent,false);
            myViewHolder = new MyViewHolder(convertView);
            convertView.setTag(myViewHolder);
        }else {
            myViewHolder = (MyViewHolder)convertView.getTag();
        }
        Itemweather currentItenweather = getItem(position);
        myViewHolder.dataweather.setText(currentItenweather.getDataweather());
        myViewHolder.data2weather.setText(currentItenweather.getData2weather());
        myViewHolder.textViewweather.setText(currentItenweather.getTextViewweather());
        myViewHolder.textViewwenduzhi.setText(currentItenweather.getTextViewwenduzhi());



        return convertView;
    }
    private class MyViewHolder {
        TextView textViewwenduzhi, textViewweather,dataweather,data2weather;


        public MyViewHolder(View item) {
            textViewwenduzhi = (TextView)item.findViewById(R.id.wenduzhiweatheritem);
            textViewweather = (TextView)item.findViewById(R.id.weatherweatheritem);
            dataweather = (TextView)item.findViewById(R.id.dataweatheritem);
            data2weather = (TextView)item.findViewById(R.id.data2weatheritem);

        }
    }
}
