package com.zdkj.mydemo.View;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zdkj.mydemo.BroadCastReceiver.MyReceiver;
import com.zdkj.mydemo.Presenter.MainActivityPresenter;
import com.zdkj.mydemo.R;


public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    // 业务代码：
    // 界面业务
    // 业务流程的处理

    private EditText mUsername;
    private EditText mPassword;
    private ProgressDialog dialog;
    private MainActivityPresenter presenter;
    private Button button_login;
    private Button change_password;
    private String username;
    private String password;
    private IntentFilter intentFilter;


    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        change_password = (Button) findViewById(R.id.change_password);
        button_login = (Button) findViewById(R.id.login);
        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);
        dialog = new ProgressDialog(this);

        intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        //注册广播
        registerReceiver(MyReceiver.getInstance(), intentFilter);

        Log.i(TAG, "initView ");
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    protected void onPause() {
        super.onPause();


    }

    @Override
    protected void initListener() {// 按钮点击事件
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();//初始化数据

            }
        });
        change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChangePasswordActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override

    protected void initData() {
        username = mUsername.getText().toString();
        password = mPassword.getText().toString();
        presenter = new MainActivityPresenter(this);

        boolean checkUserInfo = checkUserInfo(username, password);

        if (checkUserInfo) {
            dialog.show();
            presenter.longin(username, password);
        } else {//选择不全哦！
            Toast.makeText(MainActivity.this, R.string.check_info, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void processClick(View v) {

    }

    /**
     * 检验用户输入——界面相关逻辑处理
     *
     * @param username
     * @param password
     * @return
     */
    private boolean checkUserInfo(String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            return false;
        } else {
            return true;
        }
    }


    /**
     * 登陆成功
     */
    public void success() {//子线程
        Log.i("xiancheng  1no", Thread.currentThread().getName());
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 登陆成功
                dialog.dismiss();
                Toast.makeText(MainActivity.this, getString(R.string.welcome) + mUsername.getText().toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, GoodRecordActivity.class);
                startActivity(intent);
                Log.i("xiancheng  2zhu", Thread.currentThread().getName());
            }
        });
    }

    /**
     * 登陆失败
     */

    public void failed() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, R.string.login_fail, Toast.LENGTH_SHORT).show();
                Log.e("xiancheng  3zhu", Thread.currentThread().getName());
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(MyReceiver.getInstance());
        Log.i(TAG, "onDestroy: 注销成功啦！！");
   /*     try {
            unregisterReceiver(new MyReceiver());
        } catch (IllegalArgumentException e) {
            if (e.getMessage().contains("Receiver not registered")) {
                // Ignore this exception. This is exactly what is desired
            } else {
                // unexpected, re-throw
                throw e;
            }
        }*/
    }
}
