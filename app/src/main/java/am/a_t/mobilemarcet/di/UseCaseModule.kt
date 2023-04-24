package am.a_t.mobilemarcet.di

import am.a_t.mobilemarcet.domain.iteractors.*
import am.a_t.mobilemarcet.domain.repo.Repository
import am.a_t.mobilemarcet.domain.useCase.*
import org.koin.dsl.module

val useCaseModule = module {

    factory<LoginUseCase> {
        LoginUseCaseImpl(get())
    }

    factory<ProductsUseCase> {
        ProductsUseCaseImpl(get())
    }

    factory<ReadUseCase> {
        ReadUseCaseImpl(get())
    }

    factory<RemoveUseCase> {
        RemoveUseCaseImpl(get())
    }

    factory<GetUserUseCase> {
        GetUserUseCaseImpl(get())
    }

}