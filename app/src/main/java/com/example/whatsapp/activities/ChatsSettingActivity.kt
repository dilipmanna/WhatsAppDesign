package com.example.whatsapp.activities

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.whatsapp.R
import kotlinx.android.synthetic.main.activity_chats_setting.*


class ChatsSettingActivity : AppCompatActivity() {
    val fontsizeArray = arrayOf("Small", "Medium", "Large")
    var selectFontItemIndex:Int = 1 //
    val appLanguageArray = arrayOf("English", "Hindi", "Bengali","Tamil")
    var selectAppLanguageIndex:Int = 0 //
    lateinit var alertDialog:AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chats_setting)
        setTitle("Chats")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        btn_font_size.setOnClickListener {
            CreateAlertDialogWithRadioButtonGroupForFont()
        }
        btn_app_language.setOnClickListener {
            CreateAlertDialogWithRadioButtonGroupForAppLanguage()
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

    fun CreateAlertDialogWithRadioButtonGroupForFont() {

        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Font size")
        builder.setSingleChoiceItems(fontsizeArray, selectFontItemIndex, { dialog, which ->
            selectFontItemIndex = which
            tv_font_size_desc.text = fontsizeArray[which]
//            when(which){
//                0 -> {
//                    checkItem = which
//                    tv_font_size_desc.text = values[which]
//                }
//                1 -> {
//                    checkItem = which
//                    tv_font_size_desc.text = values[which]
//                }
//                2 -> {
//                    checkItem = which
//                    tv_font_size_desc.text = values[which]
//                }
//            }
            alertDialog?.dismiss()
        })
        alertDialog = builder.create()
        alertDialog?.show()
    }

    fun CreateAlertDialogWithRadioButtonGroupForAppLanguage(){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("App Language")
        builder.setSingleChoiceItems(appLanguageArray, selectAppLanguageIndex, { dialog, which ->
            selectAppLanguageIndex = which
            tv_app_language_desc.text = appLanguageArray[which]
            alertDialog?.dismiss()
        })
        alertDialog = builder.create()
        alertDialog?.show()
    }
}
