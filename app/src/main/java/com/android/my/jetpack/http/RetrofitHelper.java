package com.android.my.jetpack.http;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private static final String TAG = "chenchen";
    private OkHttpClient mOkHttpClient;
    private Retrofit.Builder mBuilder;
    private Retrofit mRetrofit;
    private Interceptor mHeadersInterceptor;
    private Interceptor mEncryptInterceptor;
    private final String mBaseUrl;
    private Converter.Factory mConverterFactory;
    private RxJava2CallAdapterFactory mRxJava2CallAdapterFactory;

    public RetrofitHelper(String url) {
        this.mBaseUrl = url;
    }

    public Retrofit build() {
        if (this.mRetrofit == null) {
            this.mRetrofit = this.mBuilder.build();
        }

        return this.mRetrofit;
    }

    public void init() {
        if (this.mBuilder == null) {
            this.mBuilder = new Retrofit.Builder().client(this.createOkHttpClient())
                    .baseUrl(this.mBaseUrl)
                    .addConverterFactory(this.getConverterFactory())
                    .addCallAdapterFactory(this.getRxJava2CallAdapterFactory());
        }

    }

    public void setHeadersInterceptor(Interceptor interceptor) {
        this.mHeadersInterceptor = interceptor;
    }

    private Interceptor getHeadersInterceptor() {
        return this.mHeadersInterceptor;
    }

    public void setEncryptInterceptor(Interceptor interceptor) {
        this.mEncryptInterceptor = interceptor;
    }

    private Interceptor getEncryptInterceptor() {
        return this.mEncryptInterceptor;
    }

    private Converter.Factory getConverterFactory() {
        if (null == this.mConverterFactory) {
            this.mConverterFactory = GsonConverterFactory.create();
        }

        return this.mConverterFactory;
    }

    private RxJava2CallAdapterFactory getRxJava2CallAdapterFactory() {
        if (null == this.mRxJava2CallAdapterFactory) {
            this.mRxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create();
        }
        return this.mRxJava2CallAdapterFactory;
    }

    public void setConverterFactory(Converter.Factory factory) {
        this.mConverterFactory = factory;
    }

    private OkHttpClient createOkHttpClient() {
        if (this.mOkHttpClient == null) {
            okhttp3.OkHttpClient.Builder okHttpClientBuild = (new OkHttpClient()).newBuilder().retryOnConnectionFailure(true).writeTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).connectTimeout(30L, TimeUnit.SECONDS);
            if (this.getHeadersInterceptor() != null) {
                okHttpClientBuild.addInterceptor(this.getHeadersInterceptor());
            }

            if (this.getEncryptInterceptor() != null) {
                okHttpClientBuild.addInterceptor(this.getEncryptInterceptor());
            }

            this.mOkHttpClient = okHttpClientBuild.build();
        }

        return this.mOkHttpClient;
    }

    private HttpLoggingInterceptor createLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            public void log(String message) {
                Log.d("chenchen", "retrofitBack = " + message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }
}