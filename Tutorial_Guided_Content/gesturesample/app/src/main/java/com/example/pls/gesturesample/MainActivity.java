package com.example.pls.gesturesample;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{

    TextView tv;
    GestureDetectorCompat gD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tryMe);
        tv.setText("ded");

        this.gD = new GestureDetectorCompat(this,this);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        tv.setText("dwn");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        tv.setText("ShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        tv.setText("1tapup");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        tv.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        tv.setText("longPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        tv.setText("Flang");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gD.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
