package com.playlab.serviceapp

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class ServicoTest : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("Script", "onCreate()")

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("Script", "onStartCommand()")

        val w = Worker(startId)
        w.start()
        return super.onStartCommand(intent, flags, startId)
    }

    inner class Worker() : Thread() {
        var count: Int = 0
        var startId: Int = 0
        var ativo: Boolean = true

        constructor(startId: Int) : this() {
            this.startId = startId
        }

        override fun run (){
            while (ativo && count < 10){
                try {
                    Thread.sleep(1000)
                }catch (e: InterruptedException){
                    e.printStackTrace()
                }
                count++
                Log.i("Script", "COUNT: $count")
            }
            stopSelf(startId)
        }
    }

}