package com.raghav.greetingkmp.di

import com.raghav.greetingkmp.ui.screens.viewmodel.MainViewModel
import org.koin.dsl.module
import org.koin.plugin.module.dsl.viewModel

val platformModule = module {
    includes(appModule)
    viewModel<MainViewModel>()
}
