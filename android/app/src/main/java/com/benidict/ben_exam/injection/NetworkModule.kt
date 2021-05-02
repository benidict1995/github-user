package com.benidict.ben_exam.injection

import com.benidict.data.service.RemoteService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideGson() }
    single { provideHttpLoggingInterceptor() }
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get(), get()) }
    single { provideExamService(get()) }
}

private fun provideGson(): Gson = GsonBuilder().create()

private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor
        = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

private fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient
        = OkHttpClient.Builder().apply {
    addInterceptor(loggingInterceptor)
}.build()

private fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit
        = Retrofit.Builder().apply {
    client(okHttpClient)
    baseUrl("https://api.github.com/")
    addConverterFactory(GsonConverterFactory.create(gson))
}.build()

private fun provideExamService(retrofit: Retrofit): RemoteService
        = retrofit.create(RemoteService::class.java)