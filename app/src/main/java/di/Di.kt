package di

import androidx.lifecycle.ViewModel
import com.example.recyclerview.MainActivityViewModel
import com.example.recyclerview.domin.NetworkRepo
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {

    single { HttpLoggingInterceptor().apply{ level = HttpLoggingInterceptor.Level.BODY} }
    single { OkHttpClient.Builder().addInterceptor(get<HttpLoggingInterceptor>()).build()  }
    single<Retrofit>{
        Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }
    single<ApiInterface> {get<Retrofit>().create(ApiInterface::class.java)  }
}


val repoModule = module {
    single { NetworkRepo(get()) }
}

val videModelModule = module {
    viewModel { MainActivityViewModel(get())}
}