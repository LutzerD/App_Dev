package com.example.pls.foverflow;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout activity_v = (RelativeLayout) findViewById(R.id.activity_main);
        switch(item.getItemId()){
            case R.id.item1:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                activity_v.setBackgroundColor(Color.RED);
                break;
            case R.id.item2:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                activity_v.setBackgroundColor(Color.BLUE);
                break;
            case R.id.item3:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                activity_v.setBackgroundColor(Color.GREEN);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
