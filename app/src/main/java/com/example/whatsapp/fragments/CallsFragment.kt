package com.example.whatsapp.fragments


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment

import com.example.whatsapp.R
import com.example.whatsapp.activities.SettingActivity

/**
 * A simple [Fragment] subclass.
 */
class CallsFragment : Fragment() {

    companion object{
        val TAG = CallsFragment::class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calls, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        //super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.calls_option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_search ->{
                Log.i(TAG,"search menu click")
                true
            }
            R.id.action_settings ->{
                Log.i(TAG,"setting menu click")
                val settingIntent = Intent(context, SettingActivity::class.java)
                startActivity(settingIntent)
                activity?.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }


}
