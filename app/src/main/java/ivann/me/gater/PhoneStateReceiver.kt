package ivann.me.gater

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager.*
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT


class PhoneStateReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        try {
            intent?.apply {
                when(getStringExtra(EXTRA_STATE)) {
                    EXTRA_STATE_RINGING -> {
                        val incomingCallNumber = getStringExtra(EXTRA_INCOMING_NUMBER)
                        Log.e("RINGING", incomingCallNumber.toString())
                        Toast.makeText(context!!, incomingCallNumber, LENGTH_SHORT).show()
                    }
                    EXTRA_STATE_OFFHOOK -> {
                        Log.e("caller", "OFFHOOK")
                    }
                    EXTRA_STATE_IDLE -> {
                        Log.e("caller", "IDLE")
                    }
                }
            }

            Toast.makeText(context, " Receiver start ", LENGTH_SHORT).show()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

}

