package edu.skku.map.week7

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    companion object{
        const val TIME = "23433"
        //const val HOUR = "234"
        //const val MINUTE = "sdf"
        const val DESCRIPTION = "12321"
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextTime = findViewById<EditText>(R.id.editTime)
        val editDescription = findViewById<EditText>(R.id.description)
        //val hour = editTextTime.text.toString().split(":")[0]
        //val minute = editTextTime.text.toString().split(":")[1]

        val btnNewActivity = findViewById<Button>(R.id.button)
        btnNewActivity.setOnClickListener {
            val time = editTextTime.text.toString()
            val description = editDescription.text.toString()
            val intent = Intent(this, MainActivity2::class.java).apply{

                putExtra(TIME, time)
                //putExtra(HOUR, hour)
                //putExtra(MINUTE, minute)
                putExtra(DESCRIPTION, description)
            }
            startActivity(intent)
        }

    }
    override fun onResume(){
        super.onResume()
        val time = findViewById<EditText>(R.id.editTime)
        time.text.clear()
        val description= findViewById<EditText>(R.id.description)
        description.text.clear()

    }
}