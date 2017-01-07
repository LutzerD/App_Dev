package com.example.pls.intentlife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Papaya extends AppCompatActivity {

    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_papaya);
        et = (EditText) findViewById(R.id.editTextInput);
        }

    public void onClick(View view){
        Intent i = new Intent(this, notWaffles.class);

        String s = et.getText().toString();
        i.putExtra("txt",s);

        startActivity(i);
    }
}
