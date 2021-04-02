package com.android.my.jetpack.model.data.entity;

import com.android.my.jetpack.model.base.BaseEntity;

public class TokenEntity extends BaseEntity {
//    {
//        "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJBTEwiXSwiZXhwIjoxNjE2OTIwOTA1LCJqdGkiOiI5ZjZjMTZkMi05Mjc3LTQ1OTgtOGNjOS04ZDlkYmU4MWEyMGMiLCJjbGllbnRfaWQiOiJjMSJ9.LIUKHoFHInDddvztUe1Xckc-jpBLXaSOZuna18YPJDCY-vzEVxNZleP0U4XwOXMt3c7JhvK3E2oW191GFIhN-dWMvICaDOHa-P1rrOYIaw2hpIT-gy6m_VXgJA6qYVgjo6yF84t3phi66Yf36sowa0gf7RdOBru6MKxsnbW23tLwv8HQiMlF_22DOd2SxrUgqkAShMBo-pwCor2_I9IX0f3fqtxzVvd_wUTHPR3Kq0u0bR2BxQglpDdquJQurauvaAMWKYx6HLYtAaDwhJJg1XqKjfBh4rfAAVdRIPqOShtEmFpI_f3sfnwEeptKirhfTfDKlT5p3eYZqxtuqjHXag",
//            "token_type": "bearer",
//            "expires_in": 172799,
//            "scope": "ALL",
//            "jti": "9f6c16d2-9277-4598-8cc9-8d9dbe81a20c"
//    }

    private String access_token;
    private String token_type;
    private String expires_in;
    private String scope;
    private String jti;

    public String getAccessToken() {
        return access_token;
    }

    public void setAccessToken(String access_token) {
        this.access_token = access_token;
    }

    public String getTokenType() {
        return token_type;
    }

    public void setTokenType(String token_type) {
        this.token_type = token_type;
    }

    public String getExpiresIn() {
        return expires_in;
    }

    public void setExpiresIn(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }

    @Override
    public String toString() {
        return "TokenResult{" +
                "access_token='" + access_token + '\'' +
                ", token_type='" + token_type + '\'' +
                ", expires_in='" + expires_in + '\'' +
                ", scope='" + scope + '\'' +
                ", jti='" + jti + '\'' +
                '}';
    }
}
