package com.upax.androidproject

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitProvider {

    fun <Api> providesApiService(api: Class<Api>): Api {
        return Retrofit.Builder()
            .baseUrl("")
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }

    private fun getOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

}

object RoomProvider {

    private const val DB_NAME = ""

//    fun getInstance(context: Context): MyDatabase {
//        return buildRoom(context)
//    }
//
//    private fun buildRoom(context: Context): MyDatabase {
//        return Room.databaseBuilder(context, MyDatabase::class.java, DB_NAME)
//            .allowMainThreadQueries()
////            .addMigrations(MyMigrationHelper.MIGRATION_1_2)
//            .fallbackToDestructiveMigration()
//            .build()
//    }

}

object PreferencesProvider {

    private const val PREFS_NAME = ""

    fun getInstance(context: Context) {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

}
