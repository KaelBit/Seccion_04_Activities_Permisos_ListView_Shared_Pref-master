package com.alejandrolora.seccion_04_activities_permisos_list.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alejandrolora.seccion_04_activities_permisos_list.MainActivity
import com.alejandrolora.seccion_04_activities_permisos_list.R
import com.alejandrolora.seccion_04_activities_permisos_list.models.Student
import kotlinx.android.synthetic.main.activity_intent_extras.*



open class IntentExtrasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_extras)

        buttonBack.setOnClickListener{startActivity(Intent(this,IntentsActivity::class.java))}
        buttonBackMenu.setOnClickListener{startActivity(Intent(this,MainActivity::class.java))}

        val isParcelableSet = setIntentExtrasFromPreviusActivity()
        val isExtraSet = setParcelableExtraFromPreviousActivity()

        if (!isParcelableSet && !isExtraSet) checkBoxDeveloper.visibility = View.INVISIBLE

    }

    private fun setParcelableExtraFromPreviousActivity():Boolean{
        val student = intent.getParcelableExtra<Student>("student")
        if (student != null){
            textViewName.text = student.name
            textViewLastName.text = student.lastName
            textViewAge.text = "${student.age}"
            checkBoxDeveloper.text = "developer"
            checkBoxDeveloper.isChecked = student.isDeveloper
            return true
        }
        return false


    }

    private fun setIntentExtrasFromPreviusActivity():Boolean{
        val name= intent.getStringExtra("name")
        val lastName = intent.getStringExtra("lastName")

        val age:Int = intent.getIntExtra("age",-1)
        val developer = intent.getBooleanExtra("developer",false)


        if (name != null && lastName != null && age >= 0){

            textViewName.text = name
            textViewLastName.text = lastName
            textViewAge.text = "$age"
            checkBoxDeveloper.text = "developer"
            checkBoxDeveloper.isChecked = developer
            return true
        }else{
            checkBoxDeveloper.visibility = View.INVISIBLE
        }
        return false



    }


}
