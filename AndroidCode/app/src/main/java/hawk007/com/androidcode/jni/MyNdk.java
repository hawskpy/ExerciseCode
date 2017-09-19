package hawk007.com.androidcode.jni;

/**
 * Created by hawk on 2017/9/1.
 */

public class MyNdk {
    static {
        System.loadLibrary("MyLibrary");
    }
    public native String getString();
}
