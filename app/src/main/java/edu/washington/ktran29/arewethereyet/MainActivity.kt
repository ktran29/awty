package edu.washington.ktran29.arewethereyet

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val messageText = message.text
        val phoneNumber = number.text
        val nagInterval = interval.text

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlarmReceiver::class.java)
        
        button.setOnClickListener {
            if (button.text == "Start") {
                if (messageText.isNotEmpty() && phoneNumber.length == 10 && nagInterval.isNotEmpty()) {
                    Log.i(TAG, "Alarm Started")
                    button.text = "Stop"
                    intent.putExtra("message", messageText.toString())
                    intent.putExtra("number", phoneNumber.toString())
//                    Log.i(TAG, "$messageText text")

                    val alarmInterval = nagInterval.toString().toLong() * 1000 * 60
                    val alarmIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

                    alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), alarmInterval, alarmIntent)
                }

            } else {
                Log.i(TAG, "Alarm Stopped")
                button.text = "Start"
                val alarmIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT)
                alarmManager.cancel(alarmIntent)
            }
        }

    }
}
