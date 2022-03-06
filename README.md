# Retrofit Kullanımı

> Retrofit Square şirketi tarafından geliştirilen, restful web hizmetlerini kullanımını kolaylaştırmayı amaçlayan, android ve java için rest istemcisidir.


> Mevcut apilerin çalışıp çalışmadığını test etmek için [Postman](https://www.postman.com/) veya [SOAP UI](https://www.soapui.org/) gibi uygulamalar kullanabilirsiniz. 


## **Rest** (Representational State Transfer) 

## Android Kullanımı

# Kütüphanenin projeye dahil edilmesi

> Gradle Scripts > build.gradle dosyasında dependencies altına retrofit kütüphanesinin eklenmesi 
 ```java
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
 ```

> Api için interface classının oluşturulması 
```java 
interface ApiService {

    @Headers("") // Opsiyonel: Yapılan istekte header kısmında özel parametreler gönderilmek istenirse kullanılır. Token, Content-Type vb.
    @FormUrlEncoded//Opsiyonel:  Field ile parametreler gönderilecek ise kullanılır.
    @POST("apiname.php")//İstek tipinin belirtilmesi gerekir. Post, Get, Delete vb. Apiname kısmı boş olmamalıdır. Burasın yapılacak olan sayfa belirtilmelidir.
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
```
 

> Client Classının Oluşturulması

```java
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
```
Gelen JSON verisini çevirmek addConverterFactory kullanılmaktadır. Bunun için farklı converterler mevcuttur. Converterları kullanmak için kütüphanenin eklenmesi gerekmektedir.

| İsim       |       Açıklama                             |
| :---       |      :----                                 |
| Gson       | com.squareup.retrofit2:converter-gson      |
| Jackson    | com.squareup.retrofit2:converter-jackson   |
| Moshi      | com.squareup.retrofit2:converter-moshi     |
| Protobuf   | com.squareup.retrofit2:converter-protobuf  |
| Wire       | com.squareup.retrofit2:converter-wire      |
| Simple XML | com.squareup.retrofit2:converter-simplexml |
| JAXB       | com.squareup.retrofit2:converter-jaxb      |
| Scalars    | com.squareup.retrofit2:converter-scalars   |



> Response Classının Oluşturulması
```java
public class ResponseLogin {
    //Eğer değişken ismi sunucudan gelen değer ile aynı ise gerek yok  
    //fakat sunucudan gelen değer tanımlanan değerden farklı ise tanımlanması gerekir.
    //@SerializedName("sunucudanGelenParametreAdi")
    @SerializedName("status")
    int status;
    @SerializedName("msg")
    String msg;
    @SerializedName("data")
    User user;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
```

> İsteğin Yapılması
```java
//Call içerisinde response tipi belirtilmelidir. Interface de tanımlanan değer ile aynı olmalıdır. 
//Bu sorgudaki Api Url: BASE_URL + apiname.php
//api.hasanbacak.com/apiname.php
Call<ResponseLogin> responseLoginCall=Client.getApiService().Login(
    inputUsername.getText().toString().trim(),
    inputPassword.getText().toString().trim()
    );

responseLoginCall.enqueue(new Callback<ResponseLogin>() {
    @Override
    public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
        if (response.isSuccessful()){
            if (response.body().getStatus()==1) {
                Log.d(TAG, "onResponse: "+response.body().getUser().toString());
            } else {

            }
        } else {
            Log.e(TAG, "onResponse: "+response.message() );
        }
    }

     @Override
     public void onFailure(Call<ResponseLogin> call, Throwable t) {
        Log.e(TAG, "onFailure: "+t.getMessage());
     }
});
```

> Basit bir şekilde retrofit kullanımı anlatılmıştır. Burada sadece basit bir istek örneği verilmiştir. Daha fazla bilgi için kaynaklar kısmında web siteleri inceleyebilirsiniz. Eksik veya hatalı olduğunu düşündüğünüz bir kısım olursa lütfen benimle iletişime geçiniz.
>
> **İletişim :** Hbacak07@gmail.com


## Kaynaklar
1. https://square.github.io/retrofit/
