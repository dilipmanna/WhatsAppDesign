package com.example.whatsapp.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment

import com.example.whatsapp.R


class StatusFragment : Fragment() {


    companion object{
        val TAG = StatusFragment::class.java.simpleName
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
        return inflater.inflate(R.layout.fragment_status, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        //super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.status_option_menu,menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_search ->{
                Log.i(TAG,"Search menu click")
                true
            }
            R.id.action_status_privacy ->{
                Log.i(TAG,"status privacy menu click")
                true
            }
            R.id.action_settings ->{
                Log.i(TAG,"Setting menu click")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
