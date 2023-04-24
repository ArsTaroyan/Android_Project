package am.a_t.mobilemarcet.di

import am.a_t.mobilemarcet.data.preferences.Preference
import am.a_t.mobilemarcet.data.repo.RepositoryImpl
import am.a_t.mobilemarcet.domain.repo.Repository
import org.koin.dsl.module

val repositoryModule = module {

    factory<Repository> {
        RepositoryImpl(get(), get())
    }

}