package edu.washington.ktran29.arewethereyet

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val messageText = message
        val phoneNumber = number
        val nagInterval = interval

        button.setOnClickListener {
            if (button.text == "Start") {
                if (messageText.text.isNotEmpty() && phoneNumber.length() == 10 && nagInterval.text.isNotEmpty()) {
                    button.text = "Stop"
                }

            } else {
                button.text = "Start"
            }
        }

    }
}
