package com.dinesh.googlemaptest.retrofit;

import java.lang.reflect.Array;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
//    BASE_URL =192.168.35.52/testapi/register.php
//    relativeURL = register.php

    @POST("register.php")
    Call<Model> postModel(@Body Model todo);

    @POST("register.php")
    Call<List<Model>> postModelList(@Body Model todo);


    @POST("register.php")
    @FormUrlEncoded
    Call<Model> postByField(@Field("firstname") String firstname,
                        @Field("lastname") String lastname,
                        @Field("email") String email,
                        @Field("mobile") String mobile,
                        @Field("dob") String dob);


}