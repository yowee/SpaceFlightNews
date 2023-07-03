package com.myspace.spaceflightnews.di

import com.myspace.spaceflightnews.data.remote.ApiCall
import com.myspace.spaceflightnews.data.remote.ApiDetails
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module //state current class is a module
@InstallIn(SingletonComponent::class) // inform the scope of class or items inside
class RetrofitModule {


    @Provides
    fun provideOkHttpInstance(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }


    @Provides
    fun provideRetrofitInstance(
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiDetails.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }


    @Provides
    fun provideAPI(
        retrofit: Retrofit
    ): ApiCall {
        return retrofit.create(ApiCall::class.java)
    }

}