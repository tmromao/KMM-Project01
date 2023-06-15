package com.example.kmmproject01.android.tracking.adobe

import android.app.Application
import com.adobe.marketing.mobile.Analytics
import com.adobe.marketing.mobile.BuildConfig
import com.adobe.marketing.mobile.Identity
import com.adobe.marketing.mobile.InvalidInitException
import com.adobe.marketing.mobile.Lifecycle
import com.adobe.marketing.mobile.LoggingMode
import com.adobe.marketing.mobile.MobileCore
import com.example.kmmproject01.adobe.AdobeAnalyticsSdk
import com.example.kmmproject01.utils.CommonLoggerImpl

class AdobeAnalyticsSdkWrapper(app: Application) : AdobeAnalyticsSdk {

    private val propertyMap: MutableMap<String, String> = mutableMapOf()

    init {
        // https://aep-sdks.gitbook.io/docs/using-mobile-extensions/adobe-analytics#register-analytics-with-mobile-core
        MobileCore.setApplication(app)
        //setLogLevelByBuildFlavor(BuildConfig.FLAVOR) { MobileCore.setLogLevel(LoggingMode.DEBUG) }
        // MobileCore.configureWithAppID("CommonConfig.ADOBE_APP_ID") // <- Usar o ID do Empresa

        try {
            Analytics.registerExtension()
            Identity.registerExtension()
            Lifecycle.registerExtension()
            MobileCore.start(null)
        } catch (e: InvalidInitException) {
            CommonLoggerImpl().log("Could not initialize Adobe MobileCore: ${e.message}")
        }
    }

    override fun trackAction(name: String, contextData: Map<String, String>) {
        val combined = contextData.toMutableMap()
        combined.putAll(propertyMap)
        MobileCore.trackAction(name, combined)
    }

    override fun trackScreen(name: String, contextData: Map<String, String>?) {
        val combined = contextData?.toMutableMap() ?: mutableMapOf()
        combined.putAll(propertyMap)
        MobileCore.trackState(name, combined)
    }

    override fun setProperty(name: String, value: String) {
        propertyMap[name] = value
    }

    override fun unsetProperty(name: String) {
        when{
            propertyMap.containsKey(name) -> propertyMap.remove(name)
            else -> Unit
        }
    }
}