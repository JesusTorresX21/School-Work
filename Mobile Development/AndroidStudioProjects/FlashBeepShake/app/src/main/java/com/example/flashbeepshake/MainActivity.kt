package com.example.flashbeepshake

import android.annotation.TargetApi
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.ToneGenerator
import android.os.Build
import android.os.Bundle
import android.os.Vibrator
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var mCameraManager:CameraManager
    private var mCameraId:String = ""

    @TargetApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flash = findViewById<Button>(R.id.flash)
        val shake = findViewById<Button>(R.id.shake)
        val beep = findViewById<Button>(R.id.beep)

        var status:Boolean = false

        val isFlashAvailable = applicationContext.packageManager
            .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)
        if (!isFlashAvailable)
        {
            showNoFlashError()
        }

        mCameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        try
        {
            mCameraId = mCameraManager.cameraIdList[0]
        }
        catch (e:CameraAccessException) {
            e.printStackTrace()
        }
        flash.setOnClickListener {
            status = status==false
            mCameraManager.setTorchMode(mCameraId, status)

        }




        shake.setOnClickListener {
            val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            vibratorService.vibrate(500)
        }

        beep.setOnClickListener {
            val beepSound = ToneGenerator(AudioManager.STREAM_MUSIC, 50)
            beepSound.startTone(ToneGenerator.TONE_PROP_BEEP, 300)
        }

    }






    private fun showNoFlashError() {
        Toast.makeText(this,"No flash available",Toast.LENGTH_SHORT).show()
    }
}

