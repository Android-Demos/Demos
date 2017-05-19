package com.jerey.handlerthread_dead;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    HandlerThread handlerThread;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handlerThread = new HandlerThread("test");
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper());
        handlerThread.quit();
        mTextView = (TextView) findViewById(R.id.tv_main);


//        mTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Log.e("iii", "run  thread id : " + Thread.currentThread().getId());
//                        mTextView.setText("nihihs");
//                    }
//                }).start();
//            }
//        });
    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    private void func(int a) {
    }
}
