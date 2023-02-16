//
// Created by Hanson on 2023/2/16.
//

#include <jni.h>
#include "com_hanson_jnitest_MainActivity.h"
#include <string>
#include <android/log.h>
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, "In C/C++:", __VA_ARGS__);
using namespace std;

extern "C"



JNIEXPORT jstring JNICALL Java_com_hanson_jnitest_MainActivity_sayHello(JNIEnv *env, jobject)
{
    std::string str = "Hello from C++";

    return env->NewStringUTF(str.c_str());
}
