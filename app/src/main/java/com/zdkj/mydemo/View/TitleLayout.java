package com.zdkj.mydemo.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.zdkj.mydemo.R;

public class TitleLayout extends LinearLayout {


    public TitleLayout(final Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.activity_custom_title, this);


        Button button = (Button) findViewById(R.id.title_back);
        Button edit = (Button) findViewById(R.id.Title_edit);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity) getContext()).finish();//finish掉页面
            }
        });

        edit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "请输入新内容", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getContext(), NewActivity.class);
                getContext().startActivity(intent);
            }
        });

    }
}
