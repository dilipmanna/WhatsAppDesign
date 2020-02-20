package com.example.whatsapp.fragments


import android.animation.LayoutTransition
import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.whatsapp.R
import com.example.whatsapp.activities.SettingActivity
import com.example.whatsapp.adapters.ChatsAdapter
import kotlinx.android.synthetic.main.activity_dashboard.*


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

        val searchItem = menu.findItem(R.id.action_search)
        val searchManager = activity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = searchItem.actionView as SearchView

        val searchBar = searchView.findViewById<View>(R.id.search_bar) as LinearLayout
        //searchBar.layoutTransition = LayoutTransition()

        if (searchBar != null && searchBar is LinearLayout) {
            searchBar.layoutTransition = LayoutTransition()
        }

        //searchView.queryHint = "Search..."
        //val editext  = searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
        //editext.setTextColor(Color.BLACK)
        //editext.setHintTextColor(Color.GRAY)
        //val searchClose = searchView.findViewById<ImageView>(androidx.appcompat.R.id.search_close_btn)
        //searchClose.setColorFilter(Color.argb(255, 0, 0, 0))

        searchItem.setOnActionExpandListener(object : MenuItem.OnActionExpandListener{
            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
               // (activity as AppCompatActivity).supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
                menu.forEach { menuitem->
                    if (menuitem !== item) menuitem.setVisible(false)
                }

                activity?.getWindow()?.setStatusBarColor(resources.getColor(R.color.colorBlack,activity?.theme))

                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                activity?.getWindow()?.setStatusBarColor(resources.getColor(R.color.colorPrimaryDark,activity?.theme))
              // (activity as AppCompatActivity).supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.colorPrimary,context?.theme)))
                activity?.invalidateOptionsMenu()
                return true
            }

        })

        searchView.setSearchableInfo(searchManager.getSearchableInfo(activity?.componentName))
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                searchView.setQuery("",false)
                //searchItem.collapseActionView()
                Toast.makeText(context,"Submit Looking for $query",Toast.LENGTH_SHORT).show()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Toast.makeText(context,"Looking for $newText",Toast.LENGTH_SHORT).show()
                return true
            }

        })
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
                val settingIntent = Intent(context,SettingActivity::class.java)
                startActivity(settingIntent)
                activity?.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
