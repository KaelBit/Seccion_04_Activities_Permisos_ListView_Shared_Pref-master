package com.alejandrolora.seccion_04_activities_permisos_list.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.alejandrolora.seccion_04_activities_permisos_list.R
import kotlinx.android.synthetic.main.activity_intent_extras.*

class IntentExtrasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_extras)

        val name= intent.getStringExtra("name")
        val lastName = intent.getStringExtra("lastName")
        val age:Int = intent.getIntExtra("age",-1)
        val developer = intent.getBooleanExtra("developer",false)


        textViewName.text = name
        textViewLastName.text = lastName
        textViewAge.text = "$age"
        checkBoxDeveloper.isChecked = developer



    }
}
