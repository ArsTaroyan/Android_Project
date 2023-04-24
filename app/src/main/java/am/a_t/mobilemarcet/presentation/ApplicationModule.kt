package am.a_t.mobilemarcet.presentation

import am.a_t.mobilemarcet.BuildConfig
import am.a_t.mobilemarcet.di.*
import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ApplicationModule: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(apiModule, repositoryModule, viewModelModule, preferenceModule, useCaseModule)
        }

    }

}