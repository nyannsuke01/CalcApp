package jp.techacademy.shingo.kobayashi.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val answer = intent.getDoubleExtra("RESULT",0.0)
        result.text = answer.toString()
    }
}