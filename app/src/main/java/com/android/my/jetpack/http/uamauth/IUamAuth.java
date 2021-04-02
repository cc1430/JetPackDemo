package com.android.my.jetpack.http.uamauth;


import com.android.my.jetpack.model.data.entity.TokenEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IUamAuth {

//    @POST("token")
//    @FormUrlEncoded
//    Call<TokenResult> postToken(@Field("client_id") String clientId, @Field("client_secret") String clientSecret,
//                                @Field("grant_type") String grantType);

    @POST("token")
    @FormUrlEncoded
    Observable<TokenEntity> postToken(@Field("client_id") String clientId, @Field("client_secret") String clientSecret,
                                      @Field("grant_type") String grantType);
}
