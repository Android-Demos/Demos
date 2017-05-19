package avatar.com.demos;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;
    Button button2;
    private AnimationDrawable mListenAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        imageView.setImageResource(R.drawable.listen_anim);
        mListenAnim = (AnimationDrawable) imageView.getDrawable();
//        new Thread(() -> {
//            Log.e("iii", "hello lambda");
//            Log.d("iii", "hello lambda2");
//            runOnUiThread(() -> mListenAnim.stop());
//        }).start();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListenAnim.start();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListenAnim.stop();
            }
        });
        button.setBackgroundResource(state.backgroundID);
    }

    private LogState state;
    public enum LogState {

        LOGGING(R.color.colorPrimaryDark,
                R.string.app_name),

        LOGGING1(R.color.colorPrimary,
                R.string.app_name),

        LOGGING3(R.color.colorPrimaryDark,
                 R.string.app_name),

        LOGGING4(R.color.colorPrimary,
                 R.string.app_name);

        public final int backgroundID;
        public final int titleID;

        LogState(int backgroundID, int titleID) {
            this.backgroundID = backgroundID;
            this.titleID = titleID;
        }
    }

}
