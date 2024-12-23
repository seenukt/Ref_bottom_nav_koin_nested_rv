package di

import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

data class Posts (
    @SerializedName("userId") var userId : Int?    = null,
    @SerializedName("id") var id     : Int?    = null,
    @SerializedName("title") var title  : String? = null,
    @SerializedName("completed") var completed   : String? = null
)

interface ApiInterface {
    @GET("todos/{post}")
    suspend fun fetchPost(@Path("post")post:Int): Response<Posts>
}