package com.elifersumer.myapplication.CollectApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CollectApiInstance {
    companion object
    {
        var retrofit: Retrofit?=null;
        fun getRetrofitObject():Retrofit?
        {
            if(retrofit ==null)
            {
                synchronized(CollectApiInstance::class.java)
                {
                    retrofit =Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl("https://api.collectapi.com/").build()
                }
            }
            return retrofit

        }

    }
}