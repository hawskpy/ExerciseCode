package hawk007.com.androidcode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import hawk007.com.androidcode.jni.MyNdk;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.main_tv)
    TextView mainTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainTv.setText(new MyNdk().getString());
    }
}
