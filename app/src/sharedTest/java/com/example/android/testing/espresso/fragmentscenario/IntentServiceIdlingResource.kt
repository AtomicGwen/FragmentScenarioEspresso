package com.example.android.testing.espresso.fragmentscenario

import android.app.ActivityManager
import android.content.Context
import androidx.test.espresso.IdlingResource

import com.example.android.testing.espresso.BackgroundTaskProvider
import com.example.android.testing.espresso.LoginViewModel

class IntentServiceIdlingResource() : IdlingResource {
    private var resourceCallback: IdlingResource.ResourceCallback? = null

    private val isIntentServiceRunning: Boolean
        get() {
            return LoginViewModel.taskRunning
        }

    override fun getName(): String {
        return IntentServiceIdlingResource::class.java.name
    }

    override fun isIdleNow(): Boolean {
        val idle = !isIntentServiceRunning
        if (idle && resourceCallback != null) {
            resourceCallback!!.onTransitionToIdle()
        }
        return idle
    }

    override fun registerIdleTransitionCallback(resourceCallback: IdlingResource.ResourceCallback) {
        this.resourceCallback = resourceCallback
    }
}