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
    Button btnStart,btnStop;
    int max = 10;
    Handler handler;
    TimerHandler timer1 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);


        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);

        btnStop.setEnabled(false);

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {


                tv.setText(String.valueOf(msg.arg1));
                if(tv.getText().equals("0"))
                {
                    timer1 = null;

                    btnStart.setEnabled(true);
                    btnStop.setEnabled(false);

                }

                return true;
            }
        });

    }

    @Override
    public void onClick(View v) {

        if(v == btnStart)
        {
            btnStart.setEnabled(false);
            btnStop.setEnabled(true);

            if(timer1 == null) {
                timer1 = new TimerHandler(max, handler);
                timer1.start();
            }
            else {
                timer1.isRun = true;
            }
        }
        else if(v == btnStop)
        {
            btnStart.setEnabled(true);
            btnStop.setEnabled(false);

            timer1.isRun = false;

        }

    }
}
