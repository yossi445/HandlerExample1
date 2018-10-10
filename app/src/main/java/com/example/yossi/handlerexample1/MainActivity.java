package com.example.yossi.handlerexample1;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView tv;
    Button btnStart;
    int max = 10;
    Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        btnStart = findViewById(R.id.btnStart);

        btnStart.setOnClickListener(this);

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {


                tv.setText(String.valueOf(msg.arg1));

                return true;
            }
        });

    }

    @Override
    public void onClick(View v) {

        if(v == btnStart)
        {
            btnStart.setEnabled(false);

            TimerHandler timer1 = new TimerHandler(max,handler);
            timer1.start();
        }

    }
}
