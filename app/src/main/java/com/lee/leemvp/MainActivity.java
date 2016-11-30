package com.lee.leemvp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lee.leemvp.model.User;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;


    Thread t1;


    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Toast.makeText(MainActivity.this,msg.what+"",Toast.LENGTH_SHORT).show();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //第一：默认初始化
        Bmob.initialize(this, "82a2de5e0243935636e49ddcf40e6d8e");

        button= (Button) findViewById(R.id.btn);
        button.setOnClickListener(this);

//        MyRunnable myRunnable=new MyRunnable(this,handler);
//        t1= new Thread(myRunnable);
//        t1.start();
    }

    @Override
    public void onClick(View view) {
        User user=new User("李鑫鑫",22);

        user.save(new SaveListener<String>() {
            @Override
            public void done(String objectId, BmobException e) {
                if(e==null){
                    Log.e("lee","objectId"+objectId);
                }else{
                    Log.e("lee","创建数据失败：" + e.getMessage());
                }
            }
        });

       // startActivity(new Intent(this, LeeBackActivity.class));
    }
}
