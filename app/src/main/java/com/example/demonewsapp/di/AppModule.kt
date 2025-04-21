package com.example.demonewsapp.di


import com.example.demonewsapp.data.AppConstants
import com.example.demonewsapp.data.api.ApiService
import com.example.demonewsapp.data.DataSource
import com.example.demonewsapp.data.DataSourceImpliment
import com.example.demonewsapp.ui.repository.NewsRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module

@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideRetrofit():Retrofit{
         // Logs request/response details (useful for debugging)
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }

        // OkHttpClient does the actual network request
        val httpClient = OkHttpClient.Builder().apply {
            addInterceptor(httpLoggingInterceptor)
            readTimeout(60, TimeUnit.SECONDS)
            connectTimeout(60, TimeUnit.SECONDS)
        }

        // Moshi handles JSON-to-Kotlin conversion

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        return Retrofit.Builder()
            .baseUrl(AppConstants.APP_BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(MoshiConverterFactory.create(moshi))

            .build()
    }
@Provides
@Singleton
    fun provideApiService(retrofit:Retrofit):ApiService{

        return retrofit.create(ApiService::class.java)
    }
    @Provides
    @Singleton
    fun providesNewsDataSource(apiService: ApiService):DataSource{
        return DataSourceImpliment(apiService)
    }
    @Provides
    @Singleton
    fun providesNewsRepository(dataSource: DataSource): NewsRepository {
       return NewsRepository(dataSource)
    }



}
