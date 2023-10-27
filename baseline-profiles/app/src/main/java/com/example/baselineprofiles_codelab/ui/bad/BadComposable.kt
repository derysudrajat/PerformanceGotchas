package com.example.baselineprofiles_codelab.ui.bad

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BadComposable() {
    Column {
        var count by remember { mutableStateOf(0) }

        // Causes recomposition on click
        Button(onClick = { count++ }, Modifier.wrapContentSize()) {
            Text("Recompose")
        }

        Text("$count")
        count++ // Backwards write, writing to state after it has been read</b>
    }
}


@Preview
@Composable
private fun PreviewBad(){
    BadComposable()
}