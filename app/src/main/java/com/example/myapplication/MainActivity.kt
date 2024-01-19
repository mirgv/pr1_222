package com.example.myapplication

import android.app.Dialog
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {


    lateinit var pref: SharedPreferences
    lateinit var log: EditText
    lateinit var parol: EditText
    lateinit var texts1:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        log = findViewById(R.id.login);
        parol = findViewById(R.id.pass);
        texts1 = findViewById(R.id.t1)
    }
fun a()
{

}
    fun handler(v: View) {
        if (v.getId() == R.id.save) {
            var pref = getPreferences(MODE_PRIVATE);
            val ed: SharedPreferences.Editor = pref.edit()
            ed.putString("login", log.getText().toString());
            ed.putString("password", parol.getText().toString());
            ed.apply();
        }
        if (v.getId() === R.id.load) {


            pref = getPreferences(MODE_PRIVATE);
            log.setText(pref.getString("login", ""))
            parol.setText(pref.getString("password", ""))


            val alertDialog = AlertDialog.Builder(this@MainActivity)
            alertDialog.setTitle("Вы уже заходили?")

            alertDialog.setMessage("Вы хотите сделать автозаполнение?")

            alertDialog.setPositiveButton("ДА"
            ) { dialog, which -> texts1.setText(pref.getString("login", ""))
                Toast.makeText(applicationContext, "Вы нажали ДА", Toast.LENGTH_SHORT).show()
            }

            
            alertDialog.setNegativeButton("НЕТ"
            ) { dialog, which ->
                Toast.makeText(applicationContext, "Вы нажали НЕТ", Toast.LENGTH_SHORT).show()
                dialog.cancel()
            }

            alertDialog.show()

        }
    }
}