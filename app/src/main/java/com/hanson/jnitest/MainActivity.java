package com.hanson.jnitest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     *使用静态代码块加载'native-lib'库,该库即为C/C++代码编译后的共享库，
     * 加载后才能让java层调用C/C++的代码。
     * 库名称由CMakeLists.txt文件中的add_library指定。通常此处名称是native-lib的话，
     * 那么编译成功的共享库名称为libnative-lib.so。
     */
    static {
        System.loadLibrary("native-lib");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(sayHello());//本地方法调用和java函数调用毫无二致

    }

    /**
     * 本地'native-lib'库中实现了的本地方法，共享库会打包到本应用中
     * 区别于普通java函数，在函数申明中多了个native字段，以及没有函数体
     */
    public native String sayHello();
}