package hawk007.com.androidcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hawk007.com.androidcode.activity.GlideLoadImageActivity;
import hawk007.com.androidcode.activity.KotlinTestActivity;

/**
 * @author hawk
 */
public class MainActivity extends Activity {

    @Bind(R.id.main_tv)
    TextView mainTv;
    @Bind(R.id.glide_example_bt)
    Button glideExampleBt;
    @Bind(R.id.kotlin_example_bt)
    Button kotlinExampleBt;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        mainTv.setText(new MyNdk().getString());
    }

    @OnClick({R.id.glide_example_bt,R.id.kotlin_example_bt})
    public void buttonClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.glide_example_bt:
                intent = new Intent(MainActivity.this, GlideLoadImageActivity.class);
                startActivity(intent);
                break;
            case R.id.kotlin_example_bt:
                intent = new Intent(MainActivity.this, KotlinTestActivity.class);
                startActivity(intent);
                break;
        }
    }


}
