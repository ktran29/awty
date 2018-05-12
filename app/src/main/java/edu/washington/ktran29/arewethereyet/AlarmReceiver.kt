package edu.washington.ktran29.arewethereyet

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsManager
import android.util.Log
import android.widget.Toast

private const val TAG = "AlarmReceiver"

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i(TAG, "onReceive Started")

        val messageText = intent?.getStringExtra("message")
        var phoneNumber = intent?.getStringExtra("number")
        val smsManager = SmsManager.getDefault()
        val piSent = PendingIntent.getBroadcast(context, 0, Intent("SMS Sent"), 0)
        val piDelivered = PendingIntent.getBroadcast(context, 0, Intent("SMS Delivered"), 0)

//        phoneNumber = "(${phoneNumber?.substring(0, 3)}) ${phoneNumber?.substring(3, 6)} ${phoneNumber?.substring(6)}"
//        Toast.makeText(context, "$phoneNumber: $messageText", Toast.LENGTH_SHORT).show()
        smsManager.sendTextMessage(phoneNumber, null, messageText, piSent, piDelivered)

        Log.i(TAG, "Message Sent")
    }
}