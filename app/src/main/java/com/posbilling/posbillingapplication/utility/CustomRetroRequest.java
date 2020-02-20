package com.posbilling.posbillingapplication.utility;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CustomRetroRequest {
    //     public final String baseUrl = "http://103.51.153.235/moulin_dev/index.php/api/"; //// developement
    // public final String baseUrl = "http://157.230.89.189/staging/index.php/api/";    ///// staging
    // public final String baseUrl = "http://157.230.89.189/live/index.php/api/";     //// stagin 2
    public final String baseUrl = "http://cms.iicebreakers.com/live/index.php/api/";    //// live

    private static CustomRetroRequest customRetroRequest = null;
    public Retrofit retrofit = null;

    /**
     * @return Instance of CustomRetroRequest class
     */
    public static CustomRetroRequest getInstance() {
        return (customRetroRequest == null) ? customRetroRequest = new CustomRetroRequest() : customRetroRequest;
    }


    /**
     * @return Instance of RetrofitAPI class
     */
    public RetrofitAPI getBaseUrl() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getClient())
                    .build();
        }
        return retrofit.create(RetrofitAPI.class);
    }

    /**
     * @return Instance of OkHttpClient class with modified timeout
     */
    private OkHttpClient getClient() {
        long HTTP_TIMEOUT = 80;
        final OkHttpClient.Builder okHttpClientBuilder = new
                OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(HTTP_TIMEOUT, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(HTTP_TIMEOUT, TimeUnit.SECONDS);
        return okHttpClientBuilder.build();
    }

}
