package mattsapp.myfavoritecards.dto

import com.squareup.moshi.Json

/**
 * Created by Matt on 1/20/2018.
 */
class CardInfo{
    @Json(name = "status")
    var status: String?= null
    @Json(name= "cards")
    var card : Card?=null
}