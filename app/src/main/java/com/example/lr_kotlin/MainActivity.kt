package com.example.lr_kotlin

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*
private lateinit var textDate: TextView
private lateinit var buttonDate: Button
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textDate = findViewById(R.id.textDate)
        buttonDate = findViewById(R.id.buttonDate)
        val calendarBox = Calendar.getInstance()
        val dateBox = DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
            calendarBox.set(Calendar.YEAR, year)
            calendarBox.set(Calendar.MONTH, month)
            calendarBox.set(Calendar.DAY_OF_MONTH, day)
            updateText(calendarBox)
        }
        buttonDate.setOnClickListener {
            DatePickerDialog(
                this, dateBox, calendarBox.get(Calendar.YEAR), calendarBox.get(Calendar.MONTH),
                calendarBox.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }
    private fun updateText(calendar: Calendar) {
        val dateFormat = "ДД-ММ-ГГГГ"
        val sdf = SimpleDateFormat(dateFormat, Locale.UK)
        textDate.setText(sdf.format(calendar.time))
    }
}