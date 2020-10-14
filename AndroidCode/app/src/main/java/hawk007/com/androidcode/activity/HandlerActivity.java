package hawk007.com.androidcode.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.ref.WeakReference;

import hawk007.com.androidcode.R;

/**
 * 采用静态内部类+弱引用的方式,避免内存泄露
 */


public class HandlerActivity extends AppCompatActivity {

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        mHandler = new MyHandler(this);

        start();
    }

    private void start() {
        Message msg = Message.obtain();
        msg.what = 1;
        mHandler.sendMessage(msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mHandler.removeCallbacksAndMessages(null);
    }

    private static class MyHandler extends Handler{

        private WeakReference<HandlerActivity> activityWeakReference;

        public MyHandler(HandlerActivity activity) {
        activityWeakReference = new WeakReference<>(activity);
        }
        @Override
        public void handleMessage (Message msg){
        HandlerActivity activity = activityWeakReference.get();
        if (activity != null) {
            // 做相应逻辑
            if (msg.what == 1) {

            }
        }
    }

    }
}