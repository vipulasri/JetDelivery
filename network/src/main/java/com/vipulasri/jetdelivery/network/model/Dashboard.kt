package com.vipulasri.jetdelivery.network.model

import com.squareup.moshi.Json

data class Dashboard(
    val data: List<Item>
) {
    data class Item(
        val viewType: ItemViewType,
        val header: Header?,
        val data: List<SubItem>
    ) {
        data class Header(
            val title: String,
            val hasMore: Boolean
        )

        data class SubItem(
            val viewType: SubItemViewType,
            val imageUrl: String,
            val title: String?,
            val subTitle: String?,
            val action: DashboardAction,
            val meta: Meta?
        ) {
            data class Meta(
                val bgColor: String?,
                val rating: String?,
                val reviewCount: String?,
                val hasFreeDelivery: Boolean
            )
        }
    }
}

data class DashboardAction(
    val type: String,
    val value: String
)

enum class ItemViewType {
    @Json(name = "horizontalScroll") HorizontalScroll,
    @Json(name = "verticalScroll") VerticalScroll
}

enum class SubItemViewType {
    @Json(name = "bannerElement") Banner,
    @Json(name = "categoryElement") Category,
    @Json(name = "restaurantElement") Restaurant
}
