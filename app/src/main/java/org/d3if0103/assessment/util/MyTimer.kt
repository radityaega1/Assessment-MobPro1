package org.d3if0103.assessment.util

import android.os.Looper
import android.util.Log

class MyTimer {
    private var secondsCount = 0
    private var handler = android.os.Handler(Looper.getMainLooper())
    private lateinit var runnable: Runnable

    fun startTimer() {
        runnable = Runnable {
            secondsCount++
            Log.i("Timer", "Detik ke: $secondsCount")
            handler.postDelayed(runnable, 1000)
        }
        handler.postDelayed(runnable, 1000)
    }

    fun stopTimer() {
        handler.removeCallbacks(runnable)
    }
}