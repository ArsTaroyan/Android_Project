package am.a_t.mobilemarcet.di

import am.a_t.mobilemarcet.domain.iteractors.LoginUseCase
import am.a_t.mobilemarcet.presentation.viewModel.MyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        MyViewModel(get(), get(), get(), get(), get())
    }

}