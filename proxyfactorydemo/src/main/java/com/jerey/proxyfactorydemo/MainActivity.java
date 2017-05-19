package com.jerey.proxyfactorydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt1).setOnClickListener(TimeProxyFactory.getProxy(this));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:

                Log.e(TAG, "button被点击");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public static class TimeInvocationHandler implements InvocationHandler {
        private Object target;

        public void setTarget(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Long time = System.currentTimeMillis();
            Object result = method.invoke(target, args);
            Log.e(TAG, "Time statistics: " + method.getName() + " cost time: " + (System
                    .currentTimeMillis() - time));
            return result;
        }
    }

    public static class TimeProxyFactory {
        public static <T> T getProxy(T target) {
            try {
                TimeInvocationHandler handler = new TimeInvocationHandler();
                handler.setTarget(target);
                return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                        target.getClass().getInterfaces(), handler);
            } catch (Exception e) {
                Log.e("TimeProxyFactory", "newProxyInstance failed, return common obj");
                e.printStackTrace();
            }
            return target;
        }
    }
}
