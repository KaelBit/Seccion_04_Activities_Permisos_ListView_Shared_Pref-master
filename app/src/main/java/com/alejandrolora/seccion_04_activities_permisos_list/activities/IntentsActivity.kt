package com.alejandrolora.seccion_04_activities_permisos_list.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.alejandrolora.seccion_04_activities_permisos_list.R
import com.alejandrolora.seccion_04_activities_permisos_list.models.Student
import kotlinx.android.synthetic.main.activity_intents.*

class IntentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intents)

        //ACCION DE CLICK GO TO DE BOTONES XML
        buttonIntentExtras.setOnClickListener { goIntentExtras() }
        buttonIntentFlags.setOnClickListener { goIntentFlags() }
        buttonIntentObjects.setOnClickListener { goIntentObjects() }

    }

    private fun goIntentExtras(){
        val intent = Intent(this,IntentExtrasActivity::class.java)
        intent.putExtra("name","Diego")
        intent.putExtra("lastName","Chávez")
        intent.putExtra("age",27)

        startActivity(intent)
    }

    private fun goIntentFlags(){
        val intent = Intent(this,IntentExtrasActivity::class.java)
        //intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY//No guarda Activity en el stack
        //intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION // no animation only
        //finish() //destruye el activity evitando que entre en el stack
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK // Borra el stack completo!!!
        startActivity(intent)
    }

    private fun goIntentObjects(){
        val intent = Intent(this,IntentExtrasActivity::class.java)
        val student = Student("Ana","Lescano",28,false)
        intent.putExtra("student",student)

        startActivity(intent)
    }




}
