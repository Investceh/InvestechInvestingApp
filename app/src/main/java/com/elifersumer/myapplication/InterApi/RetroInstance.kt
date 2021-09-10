package com.elifersumer.myapplication.InterApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance{
    companion object
    {
        var retrofit:Retrofit?=null;
        fun getRetrofitObject():Retrofit?
        {
            if(retrofit ==null)
            {
                synchronized(RetroInstance::class.java)
                {
                    retrofit =Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl("https://api-gateway.intertech.com.tr/BankingApiV01/").build()
                }
            }
            return retrofit

        }

    }
}
