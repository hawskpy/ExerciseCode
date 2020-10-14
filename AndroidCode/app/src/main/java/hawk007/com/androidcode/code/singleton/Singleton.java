package hawk007.com.androidcode.code.singleton;

/**
 * Created by hawk on 2018/2/23.
 * 单例模式
 */

public class Singleton {

    private Singleton() {
    }

    private static class SingletonLoader {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonLoader.INSTANCE;
    }
}
