package hawk007.com.androidcode.kotlin

import android.util.Log

/**
 * Created by hawk on 2018/2/22.
 */
class kotlinTest {
    fun printSum() {
        val sum = 2 - 1
        Log.d("kotlinTest.class", sum.toString())
    }


}

fun main(args: Array<String>) {
    val kotlin = kotlinTest()
    kotlin.printSum()          // 创建一个对象不用 new 关键字
}