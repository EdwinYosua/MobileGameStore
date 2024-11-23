package com.edwinyosua.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class RawgApiResponse(

    @field:SerializedName("results")
    val results: List<ResultsItem>,
//
//    @field:SerializedName("next")
//    val next: String,
//
//    @field:SerializedName("nofollow")
//    val nofollow: Boolean,
//
//    @field:SerializedName("noindex")
//    val noindex: Boolean,
//
//    @field:SerializedName("nofollow_collections")
//    val nofollowCollections: List<String>,
//
//    @field:SerializedName("previous")
//    val previous: Any,
//
//    @field:SerializedName("count")
//    val count: Int,
//
//    @field:SerializedName("description")
//    val description: String,
//
//    @field:SerializedName("seo_h1")
//    val seoH1: String,
//
//    @field:SerializedName("filters")
//    val filters: Filters,
//
//    @field:SerializedName("seo_title")
//    val seoTitle: String,
//
//    @field:SerializedName("seo_description")
//    val seoDescription: String,
//
//    @field:SerializedName("seo_keywords")
//    val seoKeywords: String
)

data class RequirementsEn(

    @field:SerializedName("minimum")
    val minimum: String,

    @field:SerializedName("recommended")
    val recommended: String
)


data class RequirementsRu(

    @field:SerializedName("minimum")
    val minimum: String,

    @field:SerializedName("recommended")
    val recommended: String
)

data class TagsItem(

    @field:SerializedName("games_count")
    val gamesCount: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("language")
    val language: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("image_background")
    val imageBackground: String,

    @field:SerializedName("slug")
    val slug: String
)

data class ParentPlatformsItem(

    @field:SerializedName("platform")
    val platform: Platform
)

data class RatingsItem(

    @field:SerializedName("count")
    val count: Int,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("percent")
    val percent: Any
)

data class Platform(

    @field:SerializedName("image")
    val image: Any,

    @field:SerializedName("games_count")
    val gamesCount: Int,

    @field:SerializedName("year_end")
    val yearEnd: Any,

    @field:SerializedName("year_start")
    val yearStart: Any,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("image_background")
    val imageBackground: String,

    @field:SerializedName("slug")
    val slug: String
)

data class ShortScreenshotsItem(

    @field:SerializedName("image")
    val image: String,

    @field:SerializedName("id")
    val id: Int
)

data class EsrbRating(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("slug")
    val slug: String
)

data class Filters(

    @field:SerializedName("years")
    val years: List<YearsItem>
)

data class AddedByStatus(

    @field:SerializedName("owned")
    val owned: Int,

    @field:SerializedName("beaten")
    val beaten: Int,

    @field:SerializedName("dropped")
    val dropped: Int,

    @field:SerializedName("yet")
    val yet: Int,

    @field:SerializedName("playing")
    val playing: Int,

    @field:SerializedName("toplay")
    val toplay: Int
)

data class StoresItem(

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("store")
    val store: Store
)

data class PlatformsItem(

    @field:SerializedName("requirements_ru")
    val requirementsRu: Any,

    @field:SerializedName("requirements_en")
    val requirementsEn: RequirementsEn,

    @field:SerializedName("released_at")
    val releasedAt: String,

    @field:SerializedName("platform")
    val platform: Platform
)

data class Store(

    @field:SerializedName("games_count")
    val gamesCount: Int,

    @field:SerializedName("domain")
    val domain: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("image_background")
    val imageBackground: String,

    @field:SerializedName("slug")
    val slug: String
)

data class GenresItem(

    @field:SerializedName("games_count")
    val gamesCount: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("image_background")
    val imageBackground: String,

    @field:SerializedName("slug")
    val slug: String
)

data class YearsItem(

    @field:SerializedName("filter")
    val filter: String,

    @field:SerializedName("nofollow")
    val nofollow: Boolean,

    @field:SerializedName("decade")
    val decade: Int,

    @field:SerializedName("count")
    val count: Int,

    @field:SerializedName("from")
    val from: Int,

    @field:SerializedName("to")
    val to: Int,

    @field:SerializedName("years")
    val years: List<YearsItem>,

    @field:SerializedName("year")
    val year: Int
)
