package com.hbacakk.retrofitkullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hbacakk.retrofitkullanimi.network.Client;
import com.hbacakk.retrofitkullanimi.response.ResponseLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void Login(String username,String password){
        Call<ResponseLogin> responseLoginCall= Client.getApiService().Login(
                username,
                password
        );

        responseLoginCall.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if (response.isSuccessful()){
                    if (response.body().getStatus()==1){
                        //Response Başarılı ise işlemler
                    }else {
                        //Response Başarısız ise işlemler
                    }
                }else {
                    //Response Başarısız ise işlemler
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                //İstek başarısız ise yapılan işlemler
            }
        });
    }
}