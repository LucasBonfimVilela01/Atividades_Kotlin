package com.example.att_fim2bi

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Product(
    @StringRes val stringNomeId: Int,
    @StringRes val stringPrecoId: Int,
    @DrawableRes val imageResourceId: Int
)
