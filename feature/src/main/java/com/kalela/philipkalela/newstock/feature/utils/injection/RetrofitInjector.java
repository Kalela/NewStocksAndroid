package com.kalela.philipkalela.newstock.feature.utils.injection;

import com.kalela.philipkalela.newstock.feature.utils.service.AuthService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInjector {
    private static HttpLoggingInterceptor interceptor =
            new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient client =
            new OkHttpClient.Builder().addInterceptor(interceptor).build();

    public static Retrofit provideRetrofit(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static AuthService provideUsersService() {
        return provideRetrofit("https://new-stock-spring-api.herokuapp.com//api/v1/")
                .create(AuthService.class);
    }
}
