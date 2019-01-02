package com.example.pls.fraggos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements fraggo1.TopSectionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void createMeme(String top, String bot) {
        Log.d("FCUK","toasting da txt");
        Toast.makeText(getApplicationContext(),top,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),bot,Toast.LENGTH_LONG).show();

    }
}
