package hawk007.com.androidcode.activity


import android.app.Activity
import android.os.Bundle
import hawk007.com.androidcode.R
import hawk007.com.androidcode.kotlin.kotlinTest

class KotlinTestActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_test)

        val kotlin = kotlinTest()
        kotlin.printSum(2, 1)
    }
}
