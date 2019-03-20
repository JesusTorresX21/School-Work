package com.example.jtcolorpicker

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.util.Log
import android.widget.*
import android.view.SurfaceView
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity(){


    //create object with color properties
    open class ColorState(var name: String, var redValue: Int, var greenValue: Int, var blueValue: Int){
        override fun toString():String {
            return name
        }
    }

    val redTest= object: ColorState("red",250,0,0){}
    val greenTest= object: ColorState("green",0,250,0){}
    val blueTest= object: ColorState("blue",0,0,250){}

    //color variables
    var redCol : Int = 0
    var blueCol : Int = 0
    var greenCol : Int = 0

    //color variable of all three put together
    var colorData : Int = 0
    //list which holds color names that are saved
    var colorKey = arrayListOf<ColorState>(redTest, greenTest, blueTest)
    //string will hold the colors name
    var colorName : String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.setDisplayShowHomeEnabled(true);
        supportActionBar!!.setLogo(R.drawable.ic_maskicon);
        supportActionBar!!.setDisplayUseLogoEnabled(true);

        //attach values
        val colScreen = findViewById<SurfaceView>(R.id.colScreen)

        val redBar = findViewById<SeekBar>(R.id.redBar)
        val redLabel = findViewById<TextView>(R.id.redLabel)

        val blueBar = findViewById<SeekBar>(R.id.blueBar)
        val blueLabel = findViewById<TextView>(R.id.blueLabel)

        val greenBar = findViewById<SeekBar>(R.id.greenBar)
        val greenLabel = findViewById<TextView>(R.id.greenLabel)

        val saveButt = findViewById<Button>(R.id.saveButt)
        val loadButt = findViewById<Button>(R.id.loadButt)
        val namer = findViewById<EditText>(R.id.namer)

        val colorSpinner = findViewById<Spinner>(R.id.colorPick)

        var index = 0


        val colorAdapter = ArrayAdapter<ColorState>(this, android.R.layout.simple_spinner_dropdown_item,
               colorKey)
        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        colorSpinner?.adapter = colorAdapter

        colorSpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                slotNumber.text = getString(R.string.slotNumber) + (position+1).toString()
                index = position
                Log.i("spinner",index.toString())
            }

        }

        redBar.max = 255
        blueBar.max = 255
        greenBar.max = 255

        saveButt.setOnClickListener {
            colorName = namer.text.toString()
            val newColorState = object : ColorState(colorName, redBar.progress, greenBar.progress, blueBar.progress){}
            colorKey.add(newColorState)
//            redSave?: return@setOnClickListener with (redSave.edit()){
//                putInt(colorName, newColorState.redValue)
//                commit()
//            }
//            greenSave?: return@setOnClickListener with (greenSave.edit()){
//                putInt(colorName, newColorState.greenValue)
//                commit()
//            }
//            blueSave?: return@setOnClickListener with (blueSave.edit()){
//                putInt(colorName, newColorState.blueValue)
//                commit()
//            }
//            redSave.edit().putInt(colorName, redBar.progress)
//            greenSave.edit().putInt(colorName, greenBar.progress)
//            blueSave.edit().putInt(colorName, blueBar.progress)

        }

        loadButt.setOnClickListener {

            redBar.progress = colorKey[index].redValue
            redCol = redBar.progress
            greenBar.progress = colorKey[index].greenValue
            greenCol = greenBar.progress
            blueBar.progress = colorKey[index].blueValue
            blueCol = blueBar.progress
            colorData = Color.rgb(redCol, greenCol, blueCol)
            colScreen.setBackgroundColor(colorData)
            Log.i("button",index.toString())

        }


        redBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                redLabel.text = progress.toString()
                redCol = progress
                colorData = Color.rgb(redCol, greenCol, blueCol)
                colScreen.setBackgroundColor(colorData)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        blueBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                blueLabel.text = progress.toString()
                blueCol = progress
                colorData = Color.rgb(redCol, greenCol, blueCol)
                colScreen.setBackgroundColor(colorData)            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        greenBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                greenLabel.text = progress.toString()
                greenCol = progress
                colorData = Color.rgb(redCol, greenCol, blueCol)
                colScreen.setBackgroundColor(colorData)            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

    }
}
