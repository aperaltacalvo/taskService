package com.example.myservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TaskService : Service() {

    private val coroutineScope = CoroutineScope(Dispatchers.Default)

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        Log.i("service_app","Servicio creado")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        coroutineScope.launch(Dispatchers.Default){
            performTask(startId)
            stopSelf()
        }


        return Service.START_NOT_STICKY
    }

    suspend fun performTask(startId : Int) {
        Log.i("service_app","Service_app_start_command "+ startId)
        var i = 0
        while(i<=3)
            try{
                delay(10_000)
                i++
            } catch (e:Exception){
                Log.i("service_app","Service running... "+ startId)

            }

    }


    override fun onDestroy() {
        super.onDestroy()
        Log.i("service_app","Service stopped")

    }
}