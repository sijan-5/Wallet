package com.generic.wallet


import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.sample01.onBoard.OnBoardActivity


class MainActivity : AppCompatActivity() {

    private val getContent =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { _->
            startActivity(Intent(this,AuthActivity::class.java))
            finish()
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getContent.launch(Intent(this,OnBoardActivity::class.java))
    }
}