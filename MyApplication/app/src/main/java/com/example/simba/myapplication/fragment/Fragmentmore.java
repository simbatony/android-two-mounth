package com.example.simba.myapplication.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import android.view.ViewGroup;


import com.example.simba.myapplication.R;

/**
 * Created by yangzhi on 2015/11/12.
 */
public class Fragmentmore extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment2, container, false);
        EditText editText = (EditText)view.findViewById(R.id.edicttext2);


        Bundle bundle = this.getArguments();
        if (bundle!=null){
            String myInt = bundle.getString("position", "没有");
            editText.setText(myInt);

        }

        return view;
    }

}
