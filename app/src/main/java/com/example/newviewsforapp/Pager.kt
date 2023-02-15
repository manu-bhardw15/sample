package com.example.newviewsforapp

import androidx.annotation.DrawableRes

data class Pager (@DrawableRes val image: Int, val des: String)

val dataList= listOf(Pager(R.drawable.logo,"Page One"),
Pager(R.drawable.logo,"Page two"))