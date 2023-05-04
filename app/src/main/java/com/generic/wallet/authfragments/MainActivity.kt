package com.generic.wallet.authfragments


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.sample01.onBoard.OnBoardActivity
import com.generic.wallet.R


class MainActivity : AppCompatActivity() {
    private val getContent =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { resultFromSample01->

            val data = resultFromSample01.data
            val exactData = data?.getStringExtra("result")
            val intent = Intent(this, AuthActivity::class.java)
            intent.putExtra("actionFromMainActivity", exactData)
            startActivity(intent)
            finish()
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getContent.launch(Intent(this,OnBoardActivity::class.java))
    }
}