package com.example.whatsapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.whatsapp.R
import com.example.whatsapp.adapters.NotificationAdapter
import com.example.whatsapp.models.NotificationSettingModel
import com.example.whatsapp.utils.ProjectConstant
import kotlinx.android.synthetic.main.activity_notifications_setting.*

class NotificationsSettingActivity : AppCompatActivity() {

    val vibrateArray = arrayOf("Off", "Default", "Short","Long")
    val popupNotificationArray = arrayOf("No popup", "Only when screen on", "Only when screen off","Always show popup")
    val lightArray = arrayOf("None", "White", "Red","Yellow","Green","Cyan","Blue","Purple")
    var selectCheckedItemIndex:Int = -1
    lateinit var alertDialog:AlertDialog

    lateinit var notificationAdapter:NotificationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications_setting)
        setTitle("Notifications")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val layoutManager = StaggeredGridLayoutManager(1,1)
        recyclerView_notification_setting.layoutManager = layoutManager
        notificationAdapter = NotificationAdapter()
        notificationAdapter.setNotificationSettingList(ProjectConstant.notification_setting_list)
        notificationAdapter.OnItemClick = { it,pos ->
            itemClicked(it,pos)
        }
        recyclerView_notification_setting.adapter = notificationAdapter
    }

    private fun itemClicked(it: NotificationSettingModel, pos: Int) {
        when(pos){
            3,9,15-> {
                selectVibrateIndex(pos)
                VibrationOptionSelection(pos)
            }
            4,10->{
                selectPopupNotificationIndex(pos)
                PopupNotificationOptionSelection(pos)
            }
            5,11->{
                selectLightIndex(pos)
                LightOptionSelection(pos)
            }
        }
    }

    private fun selectVibrateIndex(pos: Int){
        when(ProjectConstant.notification_setting_list[pos].description){
            "Off" ->selectCheckedItemIndex = 0
            "Default" ->selectCheckedItemIndex = 1
            "Short" ->selectCheckedItemIndex = 2
            "Long" ->selectCheckedItemIndex = 3
        }
    }
    private fun selectPopupNotificationIndex(pos: Int){
        when(ProjectConstant.notification_setting_list[pos].description){
            "No popup" ->selectCheckedItemIndex = 0
            "Only when screen on" ->selectCheckedItemIndex = 1
            "Only when screen off" ->selectCheckedItemIndex = 2
            "Always show popup" ->selectCheckedItemIndex = 3
        }
    }
    private fun selectLightIndex(pos: Int){
        when(ProjectConstant.notification_setting_list[pos].description){
            "None" ->selectCheckedItemIndex = 0
            "White" ->selectCheckedItemIndex = 1
            "Red" ->selectCheckedItemIndex = 2
            "Yellow" ->selectCheckedItemIndex = 3
            "Green" ->selectCheckedItemIndex = 4
            "Cyan" ->selectCheckedItemIndex = 5
            "Blue" ->selectCheckedItemIndex = 6
            "Purple" ->selectCheckedItemIndex = 7
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

    fun VibrationOptionSelection(index:Int){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Vibrate")
        builder.setSingleChoiceItems(vibrateArray, selectCheckedItemIndex, { dialog, which ->
            selectCheckedItemIndex = which
            ProjectConstant.notification_setting_list[index].description = vibrateArray[which]
            notificationAdapter.setNotificationSettingList(ProjectConstant.notification_setting_list)
            alertDialog?.dismiss()
        })
        alertDialog = builder.create()
        alertDialog?.show()
    }
    fun PopupNotificationOptionSelection(index:Int){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Popup notification")
        builder.setSingleChoiceItems(popupNotificationArray, selectCheckedItemIndex, { dialog, which ->
            selectCheckedItemIndex = which
            ProjectConstant.notification_setting_list[index].description = popupNotificationArray[which]
            notificationAdapter.setNotificationSettingList(ProjectConstant.notification_setting_list)
            alertDialog?.dismiss()
        })
        alertDialog = builder.create()
        alertDialog?.show()
    }
    fun LightOptionSelection(index:Int){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Light")
        builder.setSingleChoiceItems(lightArray, selectCheckedItemIndex, { dialog, which ->
            selectCheckedItemIndex = which
            ProjectConstant.notification_setting_list[index].description = lightArray[which]
            notificationAdapter.setNotificationSettingList(ProjectConstant.notification_setting_list)
            alertDialog?.dismiss()
        })
        alertDialog = builder.create()
        alertDialog?.show()
    }


}
