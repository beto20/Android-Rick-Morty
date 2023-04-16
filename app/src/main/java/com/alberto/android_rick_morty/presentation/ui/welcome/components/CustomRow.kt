package com.alberto.android_rick_morty.presentation.ui.welcome.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alberto.android_rick_morty.R
import com.alberto.android_rick_morty.presentation.ui.theme.Font
import com.alberto.android_rick_morty.presentation.ui.theme.SpecialButton


@Composable
fun CustomRow(
    onClick: () -> Unit,
    title: String,
    description: String
) {
    val expanded = remember { mutableStateOf(false) }

    val extraPadding by animateDpAsState(
        if (expanded.value) 24.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Surface(
        color = SpecialButton,
        modifier = Modifier
            .padding(vertical = 20.dp, horizontal = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .clickable { onClick() }
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        text = title,
                        textAlign = TextAlign.Center,
                        color = Font,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                OutlinedButton(
                    onClick = { expanded.value = !expanded.value },
                ) {
                    Text(
                        text = (
                                if (expanded.value) stringResource(id = R.string.show_less)
                                else stringResource(id = R.string.show_more)
                                ),
                        fontWeight = FontWeight.Bold,
                        color = Font,
                    )
                }
            }

            if (expanded.value) {
                Column(
                    modifier = Modifier.padding(
                        bottom = extraPadding.coerceAtLeast(0.dp)
                    )
                ) {
                    Text(
                        text = description,
                        color = Font
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CustomRowPreview() {
    CustomRow(
        { },
        title = "Locaciones",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"
    )
}