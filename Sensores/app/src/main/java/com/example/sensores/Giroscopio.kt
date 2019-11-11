package com.example.sensores

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_giroscopio.*
import kotlinx.android.synthetic.main.activity_sensor_acelerometro.*

class Giroscopio : AppCompatActivity() {
    private var mSensorManager: SensorManager? = null
    private var mGiroscopio: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_giroscopio)

        mSensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        mGiroscopio = mSensorManager?.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
    }

    override fun onResume() {
        super.onResume()
        mSensorManager?.registerListener(mGiroscopioSensor(), mGiroscopio, SensorManager.SENSOR_DELAY_UI)
    }

    override fun onPause() {
        super.onPause()
        mSensorManager?.unregisterListener(mGiroscopioSensor())
    }

    internal inner class mGiroscopioSensor : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}

        override fun onSensorChanged(event: SensorEvent) {
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]

            Log.i("SENSOR_ACELEROMETRO", "VALOR DO SENSOR = "+x+" "+y+" "+z)

            giroscopioX.setText(x.toString())
            giroscopioY.setText(y.toString())
            giroscopioZ.setText(z.toString())

        }
    }
}
