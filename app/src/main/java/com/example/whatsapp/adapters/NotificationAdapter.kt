package com.example.whatsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsapp.R
import com.example.whatsapp.models.NotificationSettingModel
import kotlinx.android.synthetic.main.notification_setting_divider_item.view.*
import kotlinx.android.synthetic.main.notification_setting_item.view.*
import kotlinx.android.synthetic.main.notification_setting_item.view.tv_title

class NotificationAdapter():RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var OnItemClick:((NotificationSettingModel, Int) -> Unit)?=null
    var mNotificationSettingList:List<NotificationSettingModel> = ArrayList()

    fun setNotificationSettingList(_notificationSettingList:List<NotificationSettingModel>){
        this.mNotificationSettingList = _notificationSettingList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == 1 )
        {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.notification_setting_item,parent,false)
            return MyViewHolder(view)

        }
        else
        {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.notification_setting_divider_item,parent,false)
            return MyViewHolderHeader(view)
        }
    }

    override fun getItemCount(): Int = mNotificationSettingList.size

    override fun getItemViewType(position: Int): Int {
        if(position == 1 || position == 7 || position == 13)
            return 2
        else
            return 1
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(position == 1 || position == 7  || position == 13 ){
            val myViewHolder: MyViewHolderHeader = holder as MyViewHolderHeader
            myViewHolder.tv_title.text = mNotificationSettingList[position].title
        }
        else{
            val myViewHolder: MyViewHolder = holder as MyViewHolder
            myViewHolder.tv_title.text = mNotificationSettingList[position].title
            myViewHolder.tv_desc.text = mNotificationSettingList[position].description
            if(mNotificationSettingList[position].isSwitch){
                myViewHolder.notification_switch.visibility = View.VISIBLE
                myViewHolder.notification_switch.isChecked = mNotificationSettingList[position].isSwitchOn
            }
            else{
                myViewHolder.notification_switch.visibility = View.GONE
            }
        }
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var tv_title: TextView = itemView.tv_title
        var tv_desc: TextView = itemView.tv_desc
        var notification_switch: Switch = itemView.notification_switch
        var btn_notification_setting: Button = itemView.btn_notification_setting

        init {
            btn_notification_setting.setOnClickListener {
                OnItemClick?.invoke(mNotificationSettingList[adapterPosition],adapterPosition)
            }
        }

    }
    inner class MyViewHolderHeader(itemView:View): RecyclerView.ViewHolder(itemView) {
        val tv_title : TextView = itemView.tv_title
    }
}