package com.example.pls.threds;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "com.example.pls.threds";

    Handler h = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            TextView tv = (TextView) findViewById(R.id.textView);
            tv.setText("noice");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void touchies(View view){

        Runnable r = new Runnable(){
            @Override
            public void run() {
                long waitTill = System.currentTimeMillis() + 10000;
                while(System.currentTimeMillis() < waitTill){
                    synchronized (this){
                        try{
                            wait(waitTill-System.currentTimeMillis());
                        }catch (Exception e){}
                    }
                }

            h.sendEmptyMessage(0);

            }
        };

        Thread newThread = new Thread(r);
        newThread.start();



    }






}
