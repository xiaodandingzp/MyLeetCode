package com.example.myleetcode.ui.theme.M;


/**
 *
 *
 * 双重检查
 * 双重检查概念是多线程开发中常使用到的，如代码中所示，我们进行了两次if (singleton == null)检查，这样就可以保证线程安全了。
 *
 * 这样，实例化代码只会执行一次，后面再次访问时，判断if (singleton == null)，直接return实例化对象，也避免的反复进行方法同步.
 *
 * 线程安全；延迟加载；效率较高
 *
 *   参考链接：https://blog.csdn.net/qq_42804736/article/details/115265060
 */
public class SingleLazy {
    private SingleLazy(){}

    private static volatile SingleLazy instance;

    static public SingleLazy getInstance() {
        if (instance == null) {
            synchronized (SingleLazy.class) {
                if (instance == null) {
                    instance = new SingleLazy();
                }
            }
        }
        return instance;
    }
}
