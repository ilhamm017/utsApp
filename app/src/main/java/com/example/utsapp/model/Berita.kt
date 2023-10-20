package com.example.utsapp.model

import android.adservices.adid.AdId
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Berita(
    @StringRes val stringResourcesId: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val linkResourcesId: Int
)