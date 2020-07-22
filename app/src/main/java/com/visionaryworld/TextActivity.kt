package com.visionaryworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_text.*

class TextActivity : AppCompatActivity() {
    var text:String?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)
        text = intent.extras!!.getString("Data")
        if(!TextUtils.isEmpty(text)){
            textTv.text = getString(R.string.text_view_heading, "AadharNumber")
            textTv1.text = text
        }
    }
}