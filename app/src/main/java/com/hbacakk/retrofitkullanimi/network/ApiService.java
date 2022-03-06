package com.hbacakk.retrofitkullanimi.network;

import com.hbacakk.retrofitkullanimi.response.ResponseLogin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    //@Headers("") // Opsiyonel: Yapılan istekte header kısmında özel parametreler gönderilmek istenirse kullanılır. Token, Content-Type vb.
    @FormUrlEncoded//Opsiyonel:  Field ile parametreler gönderilecek ise kullanılır.
    @POST("login.php")//İstek tipinin belirtilmesi gerekir. Post, Get, Delete vb. Apiname kısmı boş olmamalıdır. Burasın yapılacak olan sayfa belirtilmelidir.
    Call<ResponseLogin> Login(
            @Field("username") String username,
            @Field("password") String password
    );

    /*Call<Response Classı> responseAdi(
            @Field("parametreAdi") VeriTipi username
            );
    */
    //Field Yerine Query, Body, Header, HashMap vb. kullanılabilir.

}
