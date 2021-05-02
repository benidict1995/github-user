package com.benidict.ben_exam.injection

import com.benidict.data.gateway.UserDataGateway
import com.benidict.domain.gateway.UserGateway
import org.koin.dsl.module

val gateWayModule = module {
    single { UserDataGateway(get()) as UserGateway}
}