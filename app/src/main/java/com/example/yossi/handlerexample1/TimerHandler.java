package com.example.yossi.handlerexample1;

import android.os.Handler;
import android.os.Message;


public class TimerHandler extends Thread {


    int num;
    Handler handler;
    boolean isRun = true;

    public TimerHandler(int num, Handler handler) {
        this.num = num;
        this.handler = handler;
    }

    @Override
    public void run() {
        super.run();


        while (num > -1)
        {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (isRun) {
                Message msg = new Message();
                msg.arg1 = num;
                handler.sendMessage(msg);
                num--;
            }

        }


    }
}
