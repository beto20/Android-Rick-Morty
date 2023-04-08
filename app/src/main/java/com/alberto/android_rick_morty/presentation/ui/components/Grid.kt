package com.alberto.android_rick_morty.presentation.ui.components

import android.content.Context

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.alberto.android_rick_morty.R
import com.alberto.android_rick_morty.domain.model.BaseDomain
import java.util.*

@Composable
fun Grid(
    context: Context,
    items: List<BaseDomain?>,
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
    item: BaseDomain?,
    navigateTo: () -> Unit,
) {
    Card(
        onClick = {
            navigateTo()
            Toast.makeText(
                context,
                item?.name + " selected..",
                Toast.LENGTH_SHORT
            ).show()
        },
        modifier = Modifier.padding(6.dp),
        elevation = 6.dp,
        shape = RoundedCornerShape(size = 15.dp),
        border = BorderStroke(width = 2.dp, color = Color.Green),
    ) {
        Box {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = validateExternalImage(item),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Text(
                text = item?.name.toString(),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(
                        start = 10.dp,
                        end = 10.dp,
                        top = 8.dp
                    ),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace
            )
        }
    }
}

@Composable
private fun validateExternalImage(item: BaseDomain?): Painter {
    var painter = painterResource(id = R.drawable.rick_morty)
    if (!item?.futureUse1.isNullOrEmpty()) {
        painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data(item!!.futureUse1)
                .size(Size.ORIGINAL)
                .build()
        )
    }
    return painter
}


@Preview
@Composable
fun GridPreview() {

    val baseDomainList = listOf(
        BaseDomain(id = "1", name = "Rick Sanchez"),
        BaseDomain(id = "2", name = "Morty Smith"),
    )

    Grid(LocalContext.current, baseDomainList, {  })
}