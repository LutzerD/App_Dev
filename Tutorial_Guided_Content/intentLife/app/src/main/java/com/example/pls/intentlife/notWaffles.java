package com.example.pls.intentlife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class notWaffles extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_waffles);
        tv = (TextView) findViewById(R.id.textView);

        Bundle pass = getIntent().getExtras();
        if(pass==null){
            return;
        }
        String apples = pass.getString("txt");
        tv.setText(apples);
    }
    public void getOut(View view){


    }
}
