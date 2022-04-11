package com.xiaoyinliuyun.launchmode

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log

/**
 * adb shell dumpsys activity | grep com.xiaoyinliuyun.launchmode
 *
 * 确定几种场景：
 * 1. 启动的MainInstanceActivity和SingleInstanceActivity，各自在独立的栈中。所以使用taskAffinity只起到指定栈名的作用。
 * 2. (MainStandardActivity -> SingleTaskActivity):默认栈，-> MainTaskActivity :ddd栈， ->SingleTaskActivity 返回到 MainStandardActivity
 * 3. taskAffinity一般只配合singleTask的Activity使用。
 * 4. 一个app的两个进程的两个activity默认的任务栈是同一个吗？
 *    是的，验证：两个未指定taskAffinity的singleTask默认的activity分别在不同的进程，依次打开两个activity，在同一个栈。
 * 5. service里可以启动activity吗？
 *    可以，不管启动的是standard或singleTop的activity，还是singleTask、singleInstance 都需要用设置Flag为FLAG_ACTIVITY_NEW_TASK,因为Service是直接继承ContextWrapper的，
 *    没有任务栈信息，相当于用ApplicationContext去启动standard模式的Activity。
 */
class MainStandardActivity : Activity() {
    private val tag = "MainStandardActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(tag, "onCreate: ")

        val intent = Intent(this, MainService::class.java);
        startService(intent);
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

    fun onMainService(view: android.view.View) {
        val intent = Intent(this, MainService::class.java);
        intent.putExtra("test", 1);
        startService(intent);
    }

    fun onFirst(view: android.view.View) {
        val intent = Intent();
        intent.action = "com.test.action.LAUNCH";
        startActivity(intent);
    }


}