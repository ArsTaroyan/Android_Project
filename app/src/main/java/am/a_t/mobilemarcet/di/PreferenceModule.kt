package am.a_t.mobilemarcet.di

import am.a_t.mobilemarcet.data.preferences.Preference
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val preferenceModule = module {

    single {
        Preference(androidContext())
    }

}