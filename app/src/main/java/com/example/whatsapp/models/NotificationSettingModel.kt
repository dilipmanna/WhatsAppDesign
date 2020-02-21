package com.example.whatsapp.models

data class NotificationSettingModel (
    val title:String,
    var description:String,
    val isSwitch:Boolean,
    val isSwitchOn:Boolean
)