package com.zdkj.mydemo;

import android.os.SystemClock;

import com.zdkj.mydemo.Model.User;


public class UserLoginNet {

    /**
     * 发送用户输入数据
     *
     * @param user
     * @return
     */
    public boolean sendUserLoginInfo(User user) {


        SystemClock.sleep(3000);//模拟登陆耗时操作

        if ("hello".equals(user.getUsername()) && "bj".equals(user.getPassword())) {

            return true;

        } else {
            //登陆失败
            return false;
        }

    }
}
