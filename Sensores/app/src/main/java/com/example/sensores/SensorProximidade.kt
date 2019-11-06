package com.example.sensores

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


import kotlinx.android.synthetic.main.activity_main.*


//import kotlinx.android.synthetic.main.activity_main.*

class SensorProximidade : AppCompatActivity() {
    private var mSensorManager : SensorManager? = null
    private var mProx : Sensor? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager?
        mProx = mSensorManager?.getDefaultSensor(Sensor.TYPE_LIGHT)

        mSensorManager?.registerListener(ProxSensor(),mProx,SensorManager.SENSOR_DELAY_FASTEST)
    }

    internal inner class ProxSensor : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}

        override fun onSensorChanged(event: SensorEvent) {
            val vl = event.values[0]
            Log.i("SENSOR_PROXIMIDADE", "VALOR DO SENSOR = "+ vl)

            if (vl >= 10) {
                imgDrake.setImageResource(R.drawable.drake2)
            } else {
                imgDrake.setImageResource(R.drawable.drake)
            }

        }
    }


}
