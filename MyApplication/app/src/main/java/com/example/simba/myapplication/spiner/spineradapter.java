package com.example.simba.myapplication.spiner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.simba.myapplication.ListData;
import com.example.simba.myapplication.R;

/**
 * Created by Simba on 2015/12/02.
 */
public class spineradapter extends BaseAdapter{
    LayoutInflater inflater;
    Context context;
    String text[];
    public spineradapter(Context context,String text[]){
        this.context=context;
        this.text = text;
        inflater = LayoutInflater.from(this.context);
    }

    @Override

    public int getCount() {
        return text.length;
    }

    @Override
    public Object getItem(int position) {
        return text[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        MyViewHolder mViewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.spinerlayout_item, parent, false);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

       // ListData currentListData = getItem(position);

        mViewHolder.tvTitle.setText(text[position]);



        return convertView;
    }
    private class MyViewHolder {
        TextView tvTitle;

        public MyViewHolder(View item) {
            tvTitle = (TextView) item.findViewById(R.id.textspineritem);
        }
    }
}
