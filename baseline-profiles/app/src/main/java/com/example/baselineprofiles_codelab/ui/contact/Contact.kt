package com.example.baselineprofiles_codelab.ui.contact

import androidx.compose.ui.graphics.Color

data class Contact(
    val id: Int,
    val name: String,
    val color: Color = listOfColor.random()
)
