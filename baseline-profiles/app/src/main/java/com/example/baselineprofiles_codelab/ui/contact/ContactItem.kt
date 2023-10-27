package com.example.baselineprofiles_codelab.ui.contact

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContactItem(
    contact: Contact,
    isFirst: Boolean
) {
    val acronym by remember {
        mutableStateOf(contact.name.split(" ").let {
            if (it.size > 1) "${it.first().first().uppercase()}${it.last().first().uppercase()}"
            else contact.name.first().uppercase()
        })
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box(
            modifier = Modifier.size(32.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (isFirst) contact.name.first().uppercase() else "",
                fontSize = 24.sp
            )
        }
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(contact.color),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = acronym,
                fontSize = 24.sp,
                color = Color.White
            )
        }
        Text(
            text = contact.name,
            fontSize = 24.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewContactItem() {
    ContactItem(
        Contact(1, "Dery Sudrajat"), true
    )
}

val listOfColor = listOf(
    Color(0xFF5A91EE),
    Color(0xFF17354A),
    Color(0xFF76DB97),
    Color(0xFFE27B48),
)