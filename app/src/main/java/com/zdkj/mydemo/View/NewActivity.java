package com.zdkj.mydemo.View;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.zdkj.mydemo.R;

/**
 * Created by Administrator on 2016/12/29.
 */

public class NewActivity extends BaseActivity {

    private Button button;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_wellcome);
        button = (Button) findViewById(R.id.button);
    }

    @Override
    protected void initListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//发送标准广播
                Intent intent = new Intent("niudong");
                sendOrderedBroadcast(intent, null);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void processClick(View v) {

    }
}
