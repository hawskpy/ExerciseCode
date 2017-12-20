package hawk007.com.androidcode;

import android.app.Application;

/**
 * Created by hawk on 2017/12/20.
 */

public class CodeApplication extends Application {
    private static CodeApplication sInstance;
    public static CodeApplication getInstance() {
        return sInstance;
    }
}
