package mael.hoon.imageserach.data

import mael.hoon.imageserach.BuildConfig
import mael.hoon.imageserach.data.models.PhotoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashApiService {

    @GET(
        "photos/random?" +
                "client_id=${BuildConfig.UNSPLASH_ACCESS_KEY}" +
                "&count=30"
    )
    suspend fun getRandomPhotos(
        // ?optional로 전달 하는 이유는 null을 전달하게 되면 서비스 전체에서 랜덤사진을 뽑아오고
        // null이 아니면 쿼리에 해당하는 랜덤 사진을 가져오게 하기 위해서
        @Query("query") query: String?
    ): Response<List<PhotoResponse>>
}