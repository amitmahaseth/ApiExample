package com.example.apiexample.network

import com.example.apiexample.model.UserDetails
import com.example.apiexample.model.Users
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
  @FormUrlEncoded
  @POST("/api/v1/register")
  fun registerData(@Field("email") email: String,@Field("password") password: String,
                   @Field("platform") platform: String,@Field("device_token") device_token: String):
          Call<Users>

        @GET("posts")
  fun getData():Call<List<UserDetails>>
}