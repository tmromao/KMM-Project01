package com.example.kmmproject01.di


import com.example.kmmproject01.di.DI.Native.environment
import com.example.kmmproject01.di.FakeDI

import com.example.kmmproject01.network.Environment
import com.example.kmmproject01.settings.AppSettings
import com.example.kmmproject01.settings.SettingsService
import kotlin.native.concurrent.ThreadLocal

// 1) Renomear AndroidApp para AndroidMainApp e criar IOSMainApp
// 2) Mover dependencias comuns para DI
// 3) Criar DependencyInjectionForPreview para Android
// 4) Definir Fakes para Android
// 5) Mostrar no OnBoardingViewModel e OnboardingScreen

/**
 * CUSTOM DEPENDENCY INJECTION - HOW TO USE IT:
 *
 * 1) Add dependency either to Native (direct in lookup from method inject)
 * 2) If native, initialize it by assigning its value over MainApplication(Android)/UIApplicationDelegate(iOS)
 * 3) Add new lookup to inject method
 *
 * Usage (example):
 * val environment by inject<Environment>() OR val environment: Environment by inject()
 * */
object DI {

    @ThreadLocal
    object Native{
        //1)
        lateinit var environment: Environment //2) initialized in MainApplication/UIApplicationDelegate
        // TODO: Add more dependencies here
    }

    // PARA INJETAR NOS VIEWMODELS, REPOSITORIES, APPS OU ONDE SEJA PRECISO
    inline fun <reified T> inject(): Lazy<T> {
        // 3)

        return when(T::class) {
            Environment::class -> lazy { environment as T }
            SettingsService::class -> lazy { AppSettings() as T }
            else -> throw IllegalArgumentException("Dependency not found! Specify class \"${T::class.qualifiedName}\" in DI.inject()")
        }
    }

    // USADO PARA INJECAO DE DEPENDENCIAS APENAS NO COMMON E
    // LIMITAR ACESSO DOS APPS ATRAVES DAS INTERFACES
    internal inline fun <reified T> injectInternal(): Lazy<T> {
        return lazy { inject<T>().value }
    }

    // for Android preview [see DependencyInjectionForPreview] and testing later on
    fun fake() = FakeDI()

}