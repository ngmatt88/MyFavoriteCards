package mattsapp.myfavoritecards.dto

import com.squareup.moshi.Json

/**
 * Created by Matt on 1/20/2018.
 */
class Card{
    @Json(name = "name")
    var name: String? = null
    @Json(name = "image_path")
    var imagePath: String? = null
    @Json(name = "thumbnail_path")
    var thumbnailPath: String? = null
    @Json(name = "text")
    var text: String? = null
    @Json(name = "type")
    var type: String? = null
    @Json(name = "number")
    var number: String? = null
    @Json(name = "price_low")
    var priceLow: String? = null
    @Json(name = "price_avg")
    var priceAvg: String? = null
    @Json(name = "price_high")
    var priceHigh: String? = null
    @Json(name = "tcgplayer_link")
    var tcgplayerLink: String? = null
    @Json(name = "is_monster")
    var isMonster: Boolean? = null
    @Json(name = "is_spell")
    var isSpell: Boolean? = null
    @Json(name = "is_illegal")
    var isIllegal: Boolean? = null
    @Json(name = "is_trap")
    var isTrap: Boolean? = null
    @Json(name = "has_name_condition")
    var hasNameCondition: Boolean? = null
    @Json(name = "species")
    var species: String? = null
    @Json(name = "monster_types")
    var monsterTypes: List<String>? = null
    @Json(name = "attack")
    var attack: String? = null
    @Json(name = "defense")
    var defense: String? = null
    @Json(name = "stars")
    var stars: String? = null
    @Json(name = "attribute")
    var attribute: String? = null
    @Json(name = "is_pendulum")
    var isPendulum: Boolean? = null
    @Json(name = "is_xyz")
    var isXyz: Boolean? = null
    @Json(name = "is_synchro")
    var isSynchro: Boolean? = null
    @Json(name = "is_fusion")
    var isFusion: Boolean? = null
    @Json(name = "is_link")
    var isLink: Boolean? = null
    @Json(name = "is_extra_deck")
    var isExtraDeck: Boolean? = null
    @Json(name = "has_materials")
    var hasMaterials: Boolean? = null
//    @Json(name = "legality")
//    var legality: Legality? = null
}