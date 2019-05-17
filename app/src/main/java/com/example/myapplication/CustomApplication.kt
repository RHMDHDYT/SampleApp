package com.example.myapplication

import android.app.Application
import com.launchdarkly.android.LDClient
import com.launchdarkly.android.LDConfig
import com.launchdarkly.android.LDUser
import com.onesignal.OneSignal


class CustomApplication : Application() {

    companion object {
        lateinit var ldClient: LDClient
    }

    override fun onCreate() {
        super.onCreate()

        val ldConfig = LDConfig.Builder()
            .setMobileKey("mob-ffb4a8af-aacf-4d4a-9c90-2c41edf10e7a")
            .build()

        val user = LDUser.Builder("user key")
            .email("fake@example.com")
            .build()

        ldClient = LDClient.init(this, ldConfig, user, 0)

        // OneSignal Initialization
        OneSignal.startInit(this)
            .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
            .unsubscribeWhenNotificationsAreDisabled(true)
            .init();

    }
}