package com.zdkj.mydemo.BroadCastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/1/4.
 */

public class OtherReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "我是有序广播OtherReciver", Toast.LENGTH_LONG).show();
//        abortBroadcast();//拦截掉了在其后面的广播
    }
}
