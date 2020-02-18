package com.example.whatsapp.fragments


import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import com.example.whatsapp.R
import com.example.whatsapp.adapters.ChatsAdapter

/**
 * A simple [Fragment] subclass.
 */
class ChatsFragment : Fragment() {
    companion object{
        val TAG: String = ChatsFragment::class.java.simpleName
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
        val rootView = inflater.inflate(R.layout.fragment_chats, container, false)
        val rv = rootView.findViewById<RecyclerView>(R.id.rv_chat)

        val layoutManager = StaggeredGridLayoutManager(1,1)
        rv.layoutManager = layoutManager
        rv.setHasFixedSize(true)
        rv.adapter = ChatsAdapter()
        return rootView
    }
    override fun onPrepareOptionsMenu(menu: Menu) {
        //menu?.findItem(R.id.action_status_privacy)?.setVisible(false)
        super.onPrepareOptionsMenu(menu)

    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
       //super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.chat_option_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_search ->{
                Log.i(TAG,"search")
                true
            }
            R.id.action_new_group ->{
                Log.i(TAG,"New group")
                true
            }
            R.id.action_new_broadcast ->{
                Log.i(TAG,"New broadcast")
                true
            }
            R.id.action_whatsapp_web ->{
                Log.i(TAG,"Whatsapp web")
                true
            }
            R.id.action_starred_messages ->{
                Log.i(TAG,"Starred messages")
                true
            }
            R.id.action_settings ->{
                Log.i(TAG,"Setting")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
