package com.hbacakk.retrofitkullanimi.response;

import com.google.gson.annotations.SerializedName;

public class ResponseLogin {
    //Eğer değişken ismi sunucudan gelen değer ile aynı ise gerek yok
    //fakat sunucudan gelen değer tanımlanan değerden farklı ise tanımlanması gerekir.
    //@SerializedName("sunucudanGelenParametreAdi")
    @SerializedName("status")
    int status;
    @SerializedName("msg")
    String msg;
    @SerializedName("data")
    String data;

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

    public String getData() {
        return data;
    }

    public void getData(String data) {
        this.data = data;
    }
}
