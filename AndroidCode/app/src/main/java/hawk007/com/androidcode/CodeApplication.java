package hawk007.com.androidcode;

import android.app.Application;

import com.tencent.tinker.loader.app.TinkerApplication;

/**
 *
 * @author hawk
 * @date 2017/12/20
 */

public class CodeApplication extends TinkerApplication {
    private static CodeApplication sInstance;

    /**
     * current build.
     *
     * @param tinkerFlags
     */
    protected CodeApplication(int tinkerFlags) {
        super(tinkerFlags);
    }

    public static CodeApplication getInstance() {
        return sInstance;
    }
}
