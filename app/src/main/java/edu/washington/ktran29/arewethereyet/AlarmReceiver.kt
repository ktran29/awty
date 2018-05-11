package edu.washington.ktran29.arewethereyet

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

private const val TAG = "AlarmReceiver"

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i(TAG, "onReceive Started")

        val messageText = intent?.getStringExtra("message")
        var phoneNumber = intent?.getStringExtra("number")
        phoneNumber = "(${phoneNumber?.substring(0, 3)}) ${phoneNumber?.substring(3, 6)} ${phoneNumber?.substring(6)}"
        Toast.makeText(context, "$phoneNumber: $messageText", Toast.LENGTH_SHORT).show()
        Log.i(TAG, "Toast Created")
    }
}