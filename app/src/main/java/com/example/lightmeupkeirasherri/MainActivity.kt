package com.example.lightmeupkeirasherri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.ViewModel


class MainActivity : AppCompatActivity() {
    // this keeps track of the current image

    val imageViewModel: ImageViewModel by viewModels()

    companion object {
        private const val KEY_IMAGE = "IMAGE"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setImageDrawable(AppCompatResources.getDrawable(this, imageViewModel.state))

        /*savedInstanceState?.let {
            state = it.getInt(KEY_IMAGE)
            imageView.setImageDrawable(AppCompatResources.getDrawable(this, state))
        }*/

        imageView.setOnClickListener {
            // update the image state
            imageViewModel.nextImage()
            // then show it on screen
            imageView.setImageDrawable(AppCompatResources.getDrawable(this, imageViewModel.state))
        }
    }

    /*override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_IMAGE, state)
    }*/

}

class ImageViewModel: ViewModel() {
    var state = R.drawable.ic_home_black_24dp
    
    fun nextImage(){
        state = when (state) {
            R.drawable.ic_home_black_24dp -> R.drawable.ic_paid_black_24dp
            R.drawable.ic_paid_black_24dp -> R.drawable.ic_home_black_24dp
            else -> R.drawable.ic_paid_black_24dp}

    }
}