package com.zdkj.mydemo.Presenter;

import com.zdkj.mydemo.View.MainActivity;
import com.zdkj.mydemo.Model.User;
import com.zdkj.mydemo.UserLoginNet;

/**
 * Created by Administrator on 2016/12/29.
 */

public class MainActivityPresenter {
    //我需要调用View里边的数据
    private MainActivity activity;

    public MainActivityPresenter(MainActivity activity) {//传入上下文额
        this.activity = activity;
    }

    public void longin(String username, String password) {
        final User user = new User();
        user.setUsername(username);
        user.setPassword(password);


        new Thread(new Runnable() {
            @Override
            public void run() {
                UserLoginNet userLoginNet = new UserLoginNet();
                boolean login = userLoginNet.sendUserLoginInfo(user);
                if (login)
                    activity.success();
                else
                    activity.failed();

            }
        }).start();


    }


}



