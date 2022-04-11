package com.xiaoyinliuyun.launchmode

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log

class MainInstanceActivity : Activity() {
    private val tag = "MainInstanceActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instance)
        Log.d(tag, "onCreate: ")
    }


    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "onRestart: ")
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume: ")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d(tag, "onNewIntent: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy: ")
    }

    fun onMainStandard(view: android.view.View) {
        val intent = Intent(this, MainStandardActivity::class.java);
        startActivity(intent);
    }

    fun onMainTop(view: android.view.View) {
        val intent = Intent(this, MainTopActivity::class.java);
        startActivity(intent);
    }

    fun onMainTask(view: android.view.View) {
        val intent = Intent(this, MainTaskActivity::class.java);
        startActivity(intent);
    }

    fun onMainInstance(view: android.view.View) {
        val intent = Intent(this, MainInstanceActivity::class.java);
        startActivity(intent);
    }


    fun onStandard(view: android.view.View) {
        val intent = Intent(this, StandardActivity::class.java);
        startActivity(intent);
    }
    fun onSingleInstance(view: android.view.View) {
        val intent = Intent(this, SingleInstanceActivity::class.java);
        startActivity(intent);}
    fun onSingleTask(view: android.view.View) {
        val intent = Intent(this, SingleTaskActivity::class.java);
        startActivity(intent);}
    fun onSingleTop(view: android.view.View) {
        val intent = Intent(this, SingleTopActivity::class.java);
        startActivity(intent);}
}