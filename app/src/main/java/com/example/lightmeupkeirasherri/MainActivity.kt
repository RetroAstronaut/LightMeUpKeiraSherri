package com.example.lightmeupkeirasherri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    var state = R.drawable.ic_home_black_24dp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setOnLongClickListener{
            state = when (state){
                R.drawable.ic_home_black_24dp-> R.drawable.ic_paid_black_24dp
                R.drawable.ic_paid_black_24dp ->  R.drawable.ic_home_black_24dp
                else ->  R.drawable.ic_paid_black_24dp
            }
            imageView.setImageDrawable(getDrawable(state))
            true
        }
    }
}