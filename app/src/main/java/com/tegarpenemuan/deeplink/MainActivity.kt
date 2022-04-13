package com.tegarpenemuan.deeplink

import android.R
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.tegarpenemuan.deeplink.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val action = getIntent().action
        val data: Uri? = getIntent().data

        if (Intent.ACTION_VIEW == action && data != null) {
//            binding.mainText.setText(data.getLastPathSegment())
            val uri: Uri? = intent.data
            if (uri != null) {
                val params: List<String> = uri.getPathSegments()
                val id = params[params.size - 1]
                val name = id.split(".")

                binding.mainText.text = name[0]
            }
        } else {
            binding.mainText.text = "Hello World"
        }
    }
}