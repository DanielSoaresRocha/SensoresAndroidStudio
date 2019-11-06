package com.example.sensores

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import kotlinx.android.synthetic.main.activity_sensor_luz.*


class SensorLuz : AppCompatActivity() {
    var mLuz : Sensor? = null
    var mSensorManager : SensorManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor_luz)

        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mLuz = mSensorManager?.getDefaultSensor(Sensor.TYPE_LIGHT)

        mSensorManager?.registerListener(LuzSensor(),mLuz,SensorManager.SENSOR_DELAY_UI)

    }

    internal inner class LuzSensor : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}

        override fun onSensorChanged(event: SensorEvent) {
            val vl = event.values[0]

            Log.i("SENSOR_LUZ", "VALOR DO SENSOR = "+ vl)

            if (vl < 10) {
                telaLuz.setBackgroundColor(Color.WHITE)
            } else {
                telaLuz.setBackgroundColor(Color.BLACK)
            }
        }
    }
}
