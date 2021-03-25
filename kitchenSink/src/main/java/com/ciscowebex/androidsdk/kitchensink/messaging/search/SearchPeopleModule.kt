package com.ciscowebex.androidsdk.kitchensink.messaging.search

import com.ciscowebex.androidsdk.kitchensink.person.PersonRepository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val searchPeopleModule = module {
    viewModel { SearchPeopleViewModel(get()) }
}