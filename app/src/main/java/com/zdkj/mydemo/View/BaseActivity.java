package com.zdkj.mydemo.View;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

/**
 * Created by Administrator on 2016/12/29.
 */

public abstract class BaseActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题
        initView();
        initData();
        initListener();
    }

    protected abstract void initView();

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void processClick(View v);

    @Override
    public void onClick(View v) {
        processClick(v);
    }
}
