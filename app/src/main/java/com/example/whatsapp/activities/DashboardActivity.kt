package com.example.whatsapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.Window
import androidx.fragment.app.FragmentManager
import com.example.whatsapp.R
import com.example.whatsapp.adapters.DashboardViewPager
import com.example.whatsapp.fragments.CallsFragment
import com.example.whatsapp.fragments.ChatsFragment
import com.example.whatsapp.fragments.StatusFragment
import kotlinx.android.synthetic.main.activity_dashboard.*


class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        setSupportActionBar(toolbar)

        val adapter = DashboardViewPager(supportFragmentManager)
        adapter.addFragment(ChatsFragment(), "CHATS")
        adapter.addFragment(StatusFragment(), "STATUS")
        adapter.addFragment(CallsFragment(), "CALLS")
        viewPager_dashboard.adapter = adapter
        viewPager_dashboard.currentItem = 0
        tabs.setupWithViewPager(viewPager_dashboard)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       // menuInflater.inflate(R.menu.chat_option_menu, menu)
        return true
    }
}
