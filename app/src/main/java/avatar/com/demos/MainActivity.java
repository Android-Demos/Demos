package avatar.com.demos;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListenAnim.stop();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListenAnim.start();
                mListenAnim.stop();
            }
        });
    }
}
