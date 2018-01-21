package mattsapp.myfavoritecards.service.api

import io.reactivex.Flowable
import mattsapp.myfavoritecards.dto.CardInfo
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Matt on 1/20/2018.
 */
interface YgoHubApi{
//    @GET("all_cards")
//    fun getAllCards(): Flowable<CardListAll>

    @GET("card_info")
    fun getCardInfo(
            @Query("name") cardName: String
    ): Flowable<CardInfo>
}