package hawk007.com.androidcode.kotlin

import android.util.Log

/**
 * Created by hawk on 2018/2/22.
 */
class kotlinTest {
    fun printSum() {
        val sum = 2 - 1
        print(getStringLenth(sum))
        Log.d("kotlinTest.class", sum.toString())
    }

    fun getStringLenth(obj: Any): Int? {
        if (obj is String) {
            return obj.length
        }
        return null
    }

    fun step(){
        print("循环输出：")
        for (i in 1..10) { //  输出“1234”
            print(i)
        }
    }

}

fun main(args: Array<String>) {
    val kotlin = kotlinTest()
    kotlin.printSum()          // 创建一个对象不用 new 关键字
}