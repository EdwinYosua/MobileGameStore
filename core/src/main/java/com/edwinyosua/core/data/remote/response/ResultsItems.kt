package com.edwinyosua.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class ResultsItem(

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("rating")
    val rating: Double,

    @field:SerializedName("background_image")
    val backgroundImage: String,

//    @field:SerializedName("added")
//    val added: Int,
//
//    @field:SerializedName("metacritic")
//    val metacritic: Int,
//
//    @field:SerializedName("playtime")
//    val playtime: Int,
//
//    @field:SerializedName("short_screenshots")
//    val shortScreenshots: List<ShortScreenshotsItem>,
//
//    @field:SerializedName("platforms")
//    val platforms: List<PlatformsItem>,
//
//    @field:SerializedName("user_game")
//    val userGame: Any,
//
//    @field:SerializedName("rating_top")
//    val ratingTop: Int,
//
//    @field:SerializedName("reviews_text_count")
//    val reviewsTextCount: Int,
//
//    @field:SerializedName("ratings")
//    val ratings: List<RatingsItem>,
//
//    @field:SerializedName("genres")
//    val genres: List<GenresItem>,
//
//    @field:SerializedName("saturated_color")
//    val saturatedColor: String,
//
//
//    @field:SerializedName("added_by_status")
//    val addedByStatus: AddedByStatus,
//
//    @field:SerializedName("parent_platforms")
//    val parentPlatforms: List<ParentPlatformsItem>,
//
//    @field:SerializedName("ratings_count")
//    val ratingsCount: Int,
//
//    @field:SerializedName("slug")
//    val slug: String,
//
//    @field:SerializedName("released")
//    val released: String,
//
//    @field:SerializedName("suggestions_count")
//    val suggestionsCount: Int,
//
//    @field:SerializedName("stores")
//    val stores: List<StoresItem>,
//
//    @field:SerializedName("tags")
//    val tags: List<TagsItem>,
//
//    @field:SerializedName("tba")
//    val tba: Boolean,
//
//    @field:SerializedName("dominant_color")
//    val dominantColor: String,
//
//    @field:SerializedName("esrb_rating")
//    val esrbRating: EsrbRating,
//
//
//    @field:SerializedName("updated")
//    val updated: String,
//
//    @field:SerializedName("clip")
//    val clip: Any,
//
//    @field:SerializedName("reviews_count")
//    val reviewsCount: Int
)