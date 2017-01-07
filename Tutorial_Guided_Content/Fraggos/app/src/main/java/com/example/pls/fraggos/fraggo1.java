package com.example.pls.fraggos;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Created by pls on 05/01/17.
 */

public class fraggo1 extends Fragment{
    Button b;
    TextView tv;
    EditText et,bet;

    TopSectionListener ac;
    public interface TopSectionListener{
        public void createMeme(String top,String bot);
    }


    //This gets called by top fragment when user clicks butt
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            ac = (TopSectionListener) activity;
        }catch(ClassCastException e){

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank,container,false);
        b = (Button) view.findViewById(R.id.button);
        et = (EditText) view.findViewById(R.id.topTxt);
        bet = (EditText) view.findViewById(R.id.botTxt);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClked(v);
            }
        });


        return view;
    }

    public void buttonClked(View view){
        ac.createMeme(et.getText().toString(),bet.getText().toString());
    }
}