#include "hawk007_com_androidcode_jni_MyNdk.h"

JNIEXPORT jstring JNICALL Java_hawk007_com_androidcode_jni_MyNdk_getString
        (JNIEnv *, jobject){
    return (*env).NewStringUTF("This is mylibrary !!!");
}