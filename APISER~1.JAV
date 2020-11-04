package com.example.assignment7;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {
    @GET("users/activities")
    Call<DataModel> getData();
    @POST("users/activities")
    @FormUrlEncoded
    Call<POST> postData(@Field("user") String title,
                        @Field("email") String body,
                        @Field("value") String value);

}
