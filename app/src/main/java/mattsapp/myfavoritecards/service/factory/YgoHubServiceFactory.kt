package mattsapp.myfavoritecards.service.factory

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.Rfc3339DateJsonAdapter
import mattsapp.myfavoritecards.BuildConfig
import mattsapp.myfavoritecards.service.api.YgoHubApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by Matt on 1/20/2018.
 */
object YgoHubServiceFactory{
    private const val API_BASE_URL = "https://www.ygohub.com/api/"
    @JvmStatic fun getYgoHubService() : YgoHubApi {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        var moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
//                .add(VsResponseAdapter.FACTORY)
                .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
                .build()

        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
//                .sslSocketFactory(SSLHelper.getSSLSocketFactory())
//                .addInterceptor(VsRestInterceptor())

        //only add logging if debug mode
        if (BuildConfig.DEBUG)
            okHttpClientBuilder.addInterceptor(logging)

        var gearURL = API_BASE_URL

        val ygoHubApi = Retrofit.Builder()
                .baseUrl(gearURL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClientBuilder.build())
                .build()
        return ygoHubApi.create(YgoHubApi::class.java)
    }
}