package com.example.android.testing.espresso

class LoginViewModel  {

    companion object {
        var taskRunning:Boolean = false
    }

    fun logIn () {
        taskRunning = true
        Thread.sleep(1000)
        taskRunning = false
    }
}