package com.example.simba.myapplication.spiner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.simba.myapplication.R;

import java.util.List;

public class CustomSpinnerAdapter extends BaseAdapter {

private List<String> alertList;
private LayoutInflater mInflater;

public CustomSpinnerAdapter(Context context, Object results) {
    alertList = (List<String>) results;
    //just check if it works. 
   //in real, actual object fits in
   alertList.add("January");
    alertList.add("Feburary");
    alertList.add("March");
    mInflater = LayoutInflater.from(context);
}

@Override
public int getCount() {
    return alertList.size();
}

@Override
public Object getItem(int position) {
    return alertList.get(position);
}

@Override
public long getItemId(int position) {
    return position;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder;
    if (convertView == null) {
        convertView = mInflater.inflate(android.R.layout.simple_spinner_item, null);
        holder = new ViewHolder();
        holder.spinnerValue = (TextView) convertView.findViewById(android.R.id.text1);

        convertView.setTag(holder);
    } else {
        holder = (ViewHolder) convertView.getTag();
    }

    holder.spinnerValue.setText(alertList.get(position));
    return convertView;
}




static class ViewHolder {
    TextView spinnerValue; //spinner name
}
}