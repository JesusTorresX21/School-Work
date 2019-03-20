package com.example.appone

import android.graphics.Color
import android.nfc.Tag
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val colorButton = findViewById<Button>(R.id.changeBack)
        val changeText = findViewById<Button>(R.id.changeText)
        val texDis = findViewById<TextView>(R.id.texDis)

        colorButton.setOnClickListener { colorButton.setBackgroundColor(Color.BLUE) }
        changeText.setOnClickListener {
            if (texDis.text== getString(R.string.Hello))texDis.text = getString(R.string.GBSpace)
            else texDis.text = getString(R.string.Hello)
            Log.i("AppOne" , texDis.toString())
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
