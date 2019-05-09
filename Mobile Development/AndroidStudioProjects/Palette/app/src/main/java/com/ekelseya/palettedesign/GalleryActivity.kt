package com.ekelseya.palettedesign

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_gallery.*
import java.io.File
import java.io.FileInputStream
import java.io.ObjectInputStream

class GalleryActivity: AppCompatActivity() {
    //private var paletteMap = mutableMapOf<String, Array<ColorBlocks>>()


    private val primaryColor: ColorBlocks = ColorBlocks("Salmon", "#D67A7A", 214, 122, 122, 1)
    private val secondaryColor: ColorBlocks = ColorBlocks("Sunset Brick", "#BF5E3B", 191, 94, 59, 2)
    private val tertiaryColor: ColorBlocks = ColorBlocks("Raisin", "#805C5E", 128, 92, 94, 3)
    private val accentColor: ColorBlocks = ColorBlocks("Mustard", "#D6BD3D", 214, 189, 61, 4)

    private  var paletteArray = ArrayList<Palette>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        //paletteMap["Sample"]= arrayOf(primaryColor,secondaryColor,tertiaryColor,accentColor)
        val sample = Palette(primaryColor,secondaryColor,tertiaryColor,accentColor, "Sample")
        paletteArray.add(sample)
        onLoad()

        val updateButton = findViewById<Button>(R.id.updateList)
        updateButton.setOnClickListener {
            onResume()
        }
        val gallerySpinner = findViewById<Spinner>(R.id.spinner)
        //val paletteNames = paletteMap.keys.toList()
        val nameArrayTest = nameArray(paletteArray)

        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, nameArrayTest)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        gallerySpinner.adapter = aa
        gallerySpinner.setSelection(0)

        gallerySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@GalleryActivity, "Nothing Selected", Toast.LENGTH_LONG).show()
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                val name = paletteNames[position]
//                val tempPalette = paletteMap[name]
//                loadColor(primary_image, tempPalette!![0])
//                loadColor(secondary_image, tempPalette[1])
//                loadColor(tertiary_image, tempPalette[2])
//                loadColor(accent_image, tempPalette[3])
//                loadNames(primary_name, tempPalette[0])
//                loadHex(primary_hex, tempPalette[0])
//                loadNames(secondary_name, tempPalette[1])
//                loadHex(secondary_hex, tempPalette[1])
//                loadNames(tertiary_name, tempPalette[2])
//                loadHex(tertiary_hex, tempPalette[2])
//                loadNames(accent_name, tempPalette[3])
//                loadHex(accent_hex, tempPalette[3])
//                textPaletteName.text = name

                loadColor(primary_image, paletteArray[position].primaryBlock)
                loadColor(secondary_image, paletteArray[position].secondaryBlock)
                loadColor(tertiary_image, paletteArray[position].tertiaryBlock)
                loadColor(accent_image, paletteArray[position].accentBlock)
                loadNames(primary_name, paletteArray[position].primaryBlock)
                loadHex(primary_hex, paletteArray[position].primaryBlock)
                loadNames(secondary_name, paletteArray[position].secondaryBlock)
                loadHex(secondary_hex, paletteArray[position].secondaryBlock)
                loadNames(tertiary_name, paletteArray[position].tertiaryBlock)
                loadHex(tertiary_hex, paletteArray[position].tertiaryBlock)
                loadNames(accent_name, paletteArray[position].accentBlock)
                loadHex(accent_hex, paletteArray[position].accentBlock)
                textPaletteName.text = paletteArray[position].pName
            }
        }
    }

    private fun onLoad() {
        val favFile = File(filesDir, "favorites")
        if (favFile.exists()) {
            ObjectInputStream(FileInputStream(favFile)).use { it ->
                val loadedPalettes = it.readObject()
                when (loadedPalettes) {
                    is ArrayList<*> -> paletteArray = loadedPalettes as ArrayList<Palette>
                        //Log.i("Load", "Deserialized")
                    else -> Log.i("Load", "Failed")
                }
                //paletteMap = loadedPalettes as MutableMap<String, Array<ColorBlocks>>
            }
        }
    }

    override fun onResume() {
        super.onResume()
        onLoad()

        val gallerySpinner = findViewById<Spinner>(R.id.spinner)
        //val paletteNames = paletteMap.keys.toList()
        val nameArray = nameArray(paletteArray)

        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, nameArray)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        gallerySpinner.adapter = aa
        gallerySpinner.setSelection(0)

        gallerySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@GalleryActivity, "Nothing Selected", Toast.LENGTH_LONG).show()
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                val name = paletteNames[position]
//                val tempPalette = paletteMap[name]
//                loadColor(primary_image, tempPalette!![0])
//                loadColor(secondary_image, tempPalette[1])
//                loadColor(tertiary_image, tempPalette[2])
//                loadColor(accent_image, tempPalette[3])
//                loadNames(primary_name, tempPalette[0])
//                loadHex(primary_hex, tempPalette[0])
//                loadNames(secondary_name, tempPalette[1])
//                loadHex(secondary_hex, tempPalette[1])
//                loadNames(tertiary_name, tempPalette[2])
//                loadHex(tertiary_hex, tempPalette[2])
//                loadNames(accent_name, tempPalette[3])
//                loadHex(accent_hex, tempPalette[3])
//                textPaletteName.text = name

                loadColor(primary_image, paletteArray[position].primaryBlock)
                loadColor(secondary_image, paletteArray[position].secondaryBlock)
                loadColor(tertiary_image, paletteArray[position].tertiaryBlock)
                loadColor(accent_image, paletteArray[position].accentBlock)
                loadNames(primary_name, paletteArray[position].primaryBlock)
                loadHex(primary_hex, paletteArray[position].primaryBlock)
                loadNames(secondary_name, paletteArray[position].secondaryBlock)
                loadHex(secondary_hex, paletteArray[position].secondaryBlock)
                loadNames(tertiary_name, paletteArray[position].tertiaryBlock)
                loadHex(tertiary_hex, paletteArray[position].tertiaryBlock)
                loadNames(accent_name, paletteArray[position].accentBlock)
                loadHex(accent_hex, paletteArray[position].accentBlock)
                textPaletteName.text = paletteArray[position].pName
            }
        }
    }
    private fun loadColor(imageView: ImageView, colorBlocks: ColorBlocks){
        val backgroundColor = Color.rgb(colorBlocks.cRed, colorBlocks.cGreen, colorBlocks.cBlue)
        imageView.setBackgroundColor(backgroundColor)
    }
    private fun loadNames(textView: TextView, colorBlocks: ColorBlocks){
        textView.text = colorBlocks.cName
    }
    private fun loadHex(textView: TextView, colorBlocks: ColorBlocks){
        textView.text = colorBlocks.cHexRep
    }
    private fun nameArray(array:ArrayList<Palette>): Array<ArrayNames?> {
        val workingArray = arrayOfNulls<ArrayNames>(array.size)
        Log.i("Name", "in name array")
        Log.i("Name", array.size.toString())
        for(index in array.indices) {
            Log.i("Name", "in for loop array")
            Log.i("Name", index.toString())
            Log.i("Name", "palette name: "+array[index].pName)

            workingArray[index] = ArrayNames(array[index].pName)
            Log.i("Name", array[index].pName)
            Log.i("Name", workingArray[index].toString())
        }
        return workingArray
    }
    private class ArrayNames(string: String){
        val arrayName = string
        override fun toString(): String {
            return arrayName
        }
    }
}