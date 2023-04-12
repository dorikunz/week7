package edu.skku.map.week7

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val time = intent.getStringExtra(MainActivity.TIME)
        val description = intent.getStringExtra(MainActivity.DESCRIPTION)
        val message = findViewById<TextView>(R.id.message)
        message.text = "Do you want to set alarm on time $time with description '$description'?"

        val cancelButton = findViewById<Button>(R.id.cancelButton)
        cancelButton.setOnClickListener{
            finish()
        }

        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, description)
            putExtra(AlarmClock.EXTRA_HOUR, time!!.split(":")[0].toInt())
            putExtra(AlarmClock.EXTRA_MINUTES, time.split(":")[1].toInt())
            }

        val okButton = findViewById<Button>(R.id.okButton)
        okButton.setOnClickListener {
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

}