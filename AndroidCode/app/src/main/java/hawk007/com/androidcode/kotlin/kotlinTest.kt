@file:JvmName("kotlinTest")

package hawk007.com.androidcode.kotlin

import android.util.Log

/**
 * Created by hawk on 2018/2/22.
 */
class kotlinTest {
    fun printSum(a: Int, b: Int) {
        val sum = a - b
        print(getStringLenth(sum))
        Log.d("kotlinTest.class", sum.toString())

        val max = if (a > b) a else b

        print(max)

        // 从枚举获取值
        var color: Color = Color.BLACK
        println(Color.values())
        println(Color.valueOf("RED"))
        println(color.name)
        println(color.ordinal)

//        输出所有枚举值
        printAllValues<Color>()
    }

    inline fun <reified T : Enum<T>> printAllValues() {
        print(enumValues<T>().joinToString { it.name })
    }

    fun getStringLenth(obj: Any): Int? {
        if (obj is String) {
            return obj.length
        }
        return null
    }

    fun step() {
        print("循环输出：")
        for (i in 1..10) { //  输出“1234”
            print(i)
        }


        val a: Int = 10000
        print(a)
    }

    fun demo() {
        val list = ArrayList<String>()
        list.add("hello world")
        print(list.lastIndex)
    }

}

fun main(args: Array<String>) {
    val kotlin = kotlinTest()
    kotlin.printSum(2, 1)          // 创建一个对象不用 new 关键字
}