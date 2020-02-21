package com.example.whatsapp.utils

import com.example.whatsapp.models.NotificationSettingModel

class ProjectConstant {
    companion object{
        var notification_setting_list = listOf<NotificationSettingModel>(
            NotificationSettingModel(
                "Conversation tones",
                 "Play sounds for incoming and outgoing messages.",
                 true,
                 true
            ),
            NotificationSettingModel(
                "Messages",
                "",
                false,
                false
            ),
            NotificationSettingModel(
                "Notification tone",
                "Default(WaterDrop_preview.ogg)",
                false,
                false
            ),
            NotificationSettingModel(
                "Vibrate",
                "Default",
                false,
                false
            ),
            NotificationSettingModel(
                "Popup notification",
                "No popup",
                false,
                false
            ),
            NotificationSettingModel(
                "Light",
                "White",
                false,
                false
            ),
            NotificationSettingModel(
                "Use high priority notifications",
                "Show previews of notifications at the top of the screen",
                true,
                false
            ),
            NotificationSettingModel(
                "Groups",
                "",
                false,
                false
            ),
            NotificationSettingModel(
                "Notification tone",
                "Default(WaterDrop_preview.ogg)",
                false,
                false
            ),
            NotificationSettingModel(
                "Vibrate",
                "Default",
                false,
                false
            ),
            NotificationSettingModel(
                "Popup notification",
                "No popup",
                false,
                false
            ),
            NotificationSettingModel(
                "Light",
                "White",
                false,
                false
            ),
            NotificationSettingModel(
                "Use high priority notifications",
                "Show previews of notifications at the top of the screen",
                true,
                true
            ),
            NotificationSettingModel(
                "Calls",
                "",
                false,
                false
            ),
            NotificationSettingModel(
                "Rington",
                "Default(MiRemix.ogg)",
                false,
                false
            ),
            NotificationSettingModel(
                "Vibrate",
                "Default",
                false,
                false
            )

        )
    }
}