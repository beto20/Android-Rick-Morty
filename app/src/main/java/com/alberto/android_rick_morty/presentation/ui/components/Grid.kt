package com.alberto.android_rick_morty.presentation.ui.components

import android.content.Context

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.alberto.android_rick_morty.presentation.ui.CommonDataClass
import java.util.*

@Composable
fun Grid(
    context: Context,
    items: List<CommonDataClass>,
    navigateTo: () -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(10.dp)
    ) {
        items(items.size) {
            Grid(
                context = context,
                item = items[it],
                navigateTo = { navigateTo() }
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun Grid(
    context: Context,
    item: CommonDataClass,
    navigateTo: () -> Unit,
) {
    Card(
        onClick = {
            navigateTo()
            Toast.makeText(
                context,
                item.name + " selected..",
                Toast.LENGTH_SHORT
            ).show()
        },
        modifier = Modifier.padding(6.dp),
        elevation = 6.dp,
        shape = RoundedCornerShape(size = 15.dp),
        border = BorderStroke(width = 2.dp, color = Color.Green),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 10.dp,
                    end = 10.dp,
                    top = 8.dp,
                    bottom = 120.dp
                ),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = item.name,
                modifier = Modifier
                    .padding(
                        start = 0.dp,
                        end = 0.dp,
                        top = 0.dp,
                        bottom = 10.dp,
                    ),
                color = Color.Black
            )
        }
    }
}


@Preview
@Composable
fun GridPreview() {

    val commonDataClassList = listOf(
        CommonDataClass("Rick Sanchez", "asd"),
        CommonDataClass("Morty Smith", "asd"),
        CommonDataClass("aaaaaaaaaaaaaaaaa", "asd"),
        CommonDataClass("asd4", "asd"),
    )

    Grid(LocalContext.current, commonDataClassList, {  })
}