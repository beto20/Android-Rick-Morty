package com.alberto.android_rick_morty.ui.components

import android.content.Context

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.alberto.android_rick_morty.ui.CommonDataClass
import java.util.*

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun Grid(
    context: Context,
    items: List<CommonDataClass>
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier.padding(10.dp)
    ) {
        items(items.size) {
            Grid(
                context = context,
                item = items[it]
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun Grid(
    context: Context,
    item: CommonDataClass
) {
    Card(
        onClick = {
            Toast.makeText(
                context,
                item.name + " selected..",
                Toast.LENGTH_SHORT
            ).show()
        },
        modifier = Modifier.padding(8.dp),
        elevation = 6.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(35.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = item.name,
                modifier = Modifier.padding(4.dp),
                color = Color.Black
            )
        }
    }
}


@Preview
@Composable
fun GridPreview() {

    val commonDataClassList = listOf(
        CommonDataClass("asd", "asd"),
        CommonDataClass("asd", "asd"),
        CommonDataClass("asd", "asd"),
        CommonDataClass("asd", "asd"),
    )

    Grid(LocalContext.current, commonDataClassList)
}