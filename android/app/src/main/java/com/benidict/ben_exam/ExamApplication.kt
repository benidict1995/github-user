package com.benidict.ben_exam

import android.app.Application
import com.benidict.ben_exam.injection.gateWayModule
import com.benidict.ben_exam.injection.networkModule
import com.benidict.ben_exam.injection.useCaseModule
import com.benidict.ben_exam.injection.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ExamApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ExamApplication)
            modules(
                gateWayModule,
                networkModule,
                useCaseModule,
                viewModelModule
            )
        }
    }
}