package com.hbacakk.retrofitkullanimi.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    private static ApiService apiService=null;
    private static String BASE_URL="api.hasanbacak.com/";//Base url belirtilmelidir.

    public static ApiService getApiService() {

        if (apiService==null){
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiService=retrofit.create(ApiService.class);
        }
        return apiService;
    }
}
