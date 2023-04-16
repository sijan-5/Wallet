package com.generic.wallet


import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.sample01.onBoard.MainFragment
import com.example.sample01.onBoard.OnBoardActivity


class MainActivity : AppCompatActivity() {

    private val getContent =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            startActivity(Intent(this,AuthActivity::class.java))
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getContent.launch(Intent(this,OnBoardActivity::class.java))
    }
}