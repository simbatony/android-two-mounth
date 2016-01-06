package com.example.simba.myapplication.newlinerlayout;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by Simba on 2016/01/04.
 */
class newlinerlayout extends LinearLayout {


    public newlinerlayout(Context context) {
        super(context);
    }

    public newlinerlayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public newlinerlayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public newlinerlayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


}
