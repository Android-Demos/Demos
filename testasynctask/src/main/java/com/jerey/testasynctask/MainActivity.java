package com.jerey.testasynctask;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class MainActivity extends Activity {

    private TextView textView;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 10000; i++) {
            new MyAsyncTask().execute();
        }
        Log.d("iii", "end");

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("dsfsdfa")
                .setPositiveButton("yes ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.w("iii", "click PositiveButton executePermissionsRequest");
                    }
                })
                .setNegativeButton("false", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.w("iii", "click NegativeButton and checkDeniedPermissionsNeverAskAgain");
                    }
                })
                .create();
        dialog.show();
    }

    class MyAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d("iii", "count " + count++);
            // Log.d("iii","thread id: " + Thread.currentThread().getId());
            return null;
        }
    }
}
