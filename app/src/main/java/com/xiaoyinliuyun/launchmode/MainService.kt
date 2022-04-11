package com.xiaoyinliuyun.launchmode

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MainService : Service() {
    private val tag = "MainService"

    override fun onBind(intent: Intent): IBinder {
        Log.d(tag, "onBind: ")
        TODO("Return the communication channel to the service.")
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(tag, "onUnbind: ")
        return super.onUnbind(intent)
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(tag, "onCreate: ")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val test = intent?.getIntExtra("test", 0);

        Log.d(tag, "onStartCommand: test -> $test");
        if(test == 1){
            // 启动activity
            val it = Intent(this, MainInstanceActivity::class.java);
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK;
            startActivity(it);
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy: ")
    }

}