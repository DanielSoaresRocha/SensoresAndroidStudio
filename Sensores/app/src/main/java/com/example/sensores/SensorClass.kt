package com.example.sensores

import android.app.Activity
import android.content.Context
import android.content.Context.SENSOR_SERVICE
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

class SensorClass(var context : Context, var tipo_sensor : Int,var sensorActivity : Activity) : SensorEventListener{

    var mSensorManager : SensorManager? = null
    var mSensor : Sensor? = null

    var valorSensor = FloatArray(3)

    init {
        mSensorManager =  context.getSystemService(SENSOR_SERVICE) as SensorManager
        mSensor = mSensorManager?.getDefaultSensor(tipo_sensor)

        onResume()
    }

    fun onResume(){
        mSensorManager?.registerListener(this,mSensor,SensorManager.SENSOR_DELAY_UI)
    }

    fun onPause(){
        mSensorManager?.unregisterListener(this)
    }


    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?){
        valorSensor[0] = event!!.values[0]
        valorSensor[1] = event!!.values[1]
        valorSensor[2] = event!!.values[2]

    }

    fun getValorSensorr(): FloatArray{
        return valorSensor
    }


}