package com.example.simba.myapplication.edicttext;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Simba on 2015/12/22.
 */
public class customedicttext extends EditText {

    int i=0;
    public customedicttext(Context context) {
        super(context);
        init();
    }

    public customedicttext(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public customedicttext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public customedicttext(final Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();

    }
    static CharSequence s2;
    public void init(){
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               // System.out.println("i="+i);
              //  System.out.println("s.toString().trim().length()="+ s.toString().trim().length());


               /* if (s.toString().trim().length() > 0 & s.toString().trim().length()==4){
                    String string = s.toString() + "  ";
                    setText(string);
                    setSelection(string.length());
                    System.out.println("加空格了");
                }
                else */
               // int i=s.toString().trim().length();
                System.out.println("-----------------title---------------------");
                System.out.println("s.toString().trim().length()="+s.toString().trim().length());
                System.out.println("(s.toString().trim().length()-4) % 6=" + (s.toString().trim().length() - 4) % 6);
                System.out.println("s.toString().trim().length()% 6=" + s.toString().trim().length()% 6);

                if (s.toString().trim().length() > 0 & (s.toString().trim().length()-4) % 6 == 0 & count == 1) {
                    String string = s.toString() + "  ";
                    setText(string);
                    setSelection(string.length());
                    System.out.println("加空格了");
                } else {
                    if ( s.toString().trim().length() > 0 & s.toString().trim().length()% 6 == 4 & count == 0) {

                        int index = s.toString().length();
                        Editable editable = getText();
                        editable.delete(index  , index);

                        System.out.println("删除空格了");
                    }
                }




              /*  else {
                    if (count == 0 & s.toString().trim().length() > 1 & s.toString().trim().length() % 4 == 0) {
                       *//**//* CharSequence s2=s;

                        String string=s.toString()+"  ";
                        setText(string);
                        setSelection(string.length());
                        System.out.println("加空格了");*//**//*
                    }
                }*/

            }

            @Override
            public void afterTextChanged(Editable s) {
              /*  System.out.println("s.toString().trim().length()="+s.toString().trim().length());
                if (s.toString().trim().length()%4==0 ){
                    CharSequence s2=s;
                  //  String string = s2.toString() + "  ";
                   // setText(s.toString()+" ");
                    setSelection(s.toString().length());
                    System.out.println("加空格了");
                }*/

            }
        });
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

    }
}
