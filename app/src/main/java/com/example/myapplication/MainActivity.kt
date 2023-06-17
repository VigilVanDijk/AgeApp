package com.example.myapplication

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var agedis= findViewById<TextView>(R.id.SelAgeDis)
        var ageinmin= findViewById<TextView>(R.id.MinutesViewer)
        fun buttsec()
        {
            val cal= Calendar.getInstance()
            val yr=cal.get(Calendar.YEAR)
            val mn=cal.get(Calendar.MONTH)
            val day=cal.get(Calendar.DAY_OF_MONTH)
            DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view, Selectedyear, Selectedmonth, Selecteddayofmonth ->

                val dd="$Selecteddayofmonth/${Selectedmonth+1}/$Selectedyear"
                agedis.setText(dd)

                val aa= SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val finaldate= aa.parse(dd)
                var ninteenseventytselecteddate=(finaldate.time)/6000   //time elapsed between Jan 1 1970 to the selected date in minutes
                var ninteenseventytocurrentdateinit=aa.parse(aa.format(System.currentTimeMillis())) //current day from 1970
                var ninteenseventytocurrentdate=(ninteenseventytocurrentdateinit.time)/6000 ////time elapsed between Jan 1 1970 to the current date in minutes
                var diff=(ninteenseventytocurrentdate-ninteenseventytselecteddate)

                ageinmin.setText("You are $diff Minutes old")


            }, yr,mn,day

            ).show()


        }

        val dateset= findViewById<Button>(R.id.button)
        dateset.setOnClickListener {
            buttsec()


        }





    }






}