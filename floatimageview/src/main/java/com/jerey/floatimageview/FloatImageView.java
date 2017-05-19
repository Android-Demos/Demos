package com.jerey.floatimageview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/**
 * Created by xiamin on 5/5/17.
 */

public class FloatImageView extends ImageView {

    public FloatImageView(Context context) {
        this(context, null);
    }

    public FloatImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FloatImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TranslateAnimation animation = new TranslateAnimation(150f, 350f, 50, 50);
        animation.setDuration(3000);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE);
        this.setAnimation(animation);
        animation.start();
    }

//    public void startFloat(Interpolator interpolator){
//        TranslateAnimation animation = new TranslateAnimation(150f, 350f, 50, 50);
//        animation.setDuration(1000);
//        animation.setRepeatCount(Animation.INFINITE);
//        animation.setRepeatMode(Animation.REVERSE);
//        this.setAnimation(animation);
//        animation.start();
//    }

}
