package com.example.pls.fraggos;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by pls on 05/01/17.
 */

public class BottomPic extends Fragment {

    TextView tvTop,tvBot;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gerp,container,false);

        tvBot = (TextView) view.findViewById(R.id.tvbot);
        tvTop = (TextView) view.findViewById(R.id.tvtop);

        return view;
    }

    public void setMemeTxt(String top, String bot){
        tvBot.setText(bot);
        tvTop.setText(top);
    }


}
