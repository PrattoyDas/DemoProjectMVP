package com.example.logindemoproject.common.di.module;

import android.content.Context;

import com.example.logindemoproject.BuildConfig;
import com.example.logindemoproject.common.di.ApplicationScope;
import com.example.logindemoproject.data.ApiHelper;
import com.example.logindemoproject.data.ApiHelperImpl;
import com.example.logindemoproject.data.RetroApiService;
import com.example.logindemoproject.data.preference.AppPreferenceHelper;
import com.example.logindemoproject.data.preference.PreferenceHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jamil on 7/24/2021.
 */

@Module(includes = {ContextModule.class})
public class DataManagerModule {


    @Provides
    @ApplicationScope
    public ApiHelper apiHelper(RetroApiService retroApiService) {
        return new ApiHelperImpl(retroApiService);
    }

    @Provides
    @ApplicationScope
    public RetroApiService retroApiService(Retrofit retrofit) {

        return retrofit.create(RetroApiService.class);

    }


    @Provides
    @ApplicationScope
    public Retrofit retrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("https://sandbox.paperfly-bd.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @ApplicationScope
    public OkHttpClient okHttpClient(HttpLoggingInterceptor httpLoggingInterceptor, Interceptor requestInterCeptor) {

        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(requestInterCeptor)
                .build();

    }

    @Provides
    @ApplicationScope
    public HttpLoggingInterceptor httpLoggingInterceptor() {

        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    }

    @Provides
    @ApplicationScope
    public Interceptor requestInterceptor(final PreferenceHelper preferenceHelper) {

        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request request;
                request = original.newBuilder().build();
                try {
                    request = original.newBuilder()
                            .addHeader("Authorization", preferenceHelper.getHeaderAuthorization())
                            .addHeader("DS-Point-Code", preferenceHelper.getDSSelectedPoint())
                            .addHeader("Selected-Point-Code", preferenceHelper.getSelectedPoint())
                            .addHeader("APP-Version-Name", BuildConfig.VERSION_NAME)
                            .addHeader("APP-Version-Code", String.valueOf(BuildConfig.VERSION_CODE))
                            .addHeader("APP-Build-Type", BuildConfig.BUILD_TYPE)
                            .addHeader("APP-Application-ID", BuildConfig.APPLICATION_ID)
                            .addHeader("APP-Debug", String.valueOf(BuildConfig.DEBUG))
                            .addHeader("APP-Base-URL", String.valueOf("https://sandbox.paperfly-bd.com/")).build();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return chain.proceed(request);
            }
        };
    }


    @Provides
    @ApplicationScope
    public PreferenceHelper preferenceHelper(Context context, Gson gson) {
        return new AppPreferenceHelper(context, gson);
    }

    @Provides
    @ApplicationScope
    public Gson gson() {
        return new GsonBuilder().create();
    }


}
