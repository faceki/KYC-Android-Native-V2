package com.facekikycverification.startup

import android.content.Context
import android.content.Intent
import com.facekikycverification.ui.SdkSetting

class FacekiVerification {

    fun initiateSMSDK(context: Context, clientId: String, clientSecret: String) {
        context.startActivity(
            Intent(context, SdkSetting::class.java)
                .putExtra("ClientId", clientId)
                .putExtra("clientSecret", clientSecret)
        )
    }
}
