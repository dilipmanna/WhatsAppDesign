package com.example.whatsapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.whatsapp.R
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        setTitle("Settings")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btn_account_setting.setOnClickListener {
            val settingIntent = Intent(this,AccountActivity::class.java)
            startActivity(settingIntent)
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
        }
        btn_chat_setting.setOnClickListener {
            val settingIntent = Intent(this,ChatsSettingActivity::class.java)
            startActivity(settingIntent)
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        finish()
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right)
        super.onBackPressed()
    }
}
