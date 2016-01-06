package com.example.simba.myapplication.fragment;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.simba.myapplication.R;

public class Fragmentmain extends Fragment {

        Button button_fragment1;
        EditText editText;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View view =inflater.inflate(R.layout.fragment1, container, false);

        button_fragment1 = (Button) view.findViewById(R.id.fragment1_button);
        editText = (EditText)view.findViewById(R.id.edicttext1);

        button_fragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    Fragmentmore fTwo = new Fragmentmore();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction tx = fm.beginTransaction();

                    Bundle bundle = new Bundle();
                    bundle.putString("position",editText.getText().toString());
                    fTwo.setArguments(bundle);

                    tx.replace(R.id.fragment, fTwo, "TWO");
                    tx.addToBackStack(null);
                    tx.commit();



            }
        });
            return view;
    }


/*    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button = (Button) getActivity().findViewById(R.id.fragment1_button);
*//*        button.setOnClickListener(new DialogInterface.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) getActivity().findViewById(R.id.edicttext1);
                Toast.makeText(getActivity(), textView.getText(), Toast.LENGTH_LONG).show();
            }
        });*//*
    }*/

}

