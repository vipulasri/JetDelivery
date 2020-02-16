package com.vipulasri.jetdelivery.network.model

data class Dashboard(
    val data: List<Item>
) {
    data class Item(
        val viewType: String,
        val header: Header?,
        val data: List<SubItem>
    ) {
        data class Header(
            val title: String,
            val hasMore: Boolean
        )

        data class SubItem(
            val viewType: String,
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