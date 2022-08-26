package com.playlab.serviceapp

import android.app.Service
import android.content.Intent
import android.os.IBinder

class ServicoTest : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
    }
}