package ie.setu.artisan1.ui.components.record

import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import ie.setu.artisan1.data.ArtisanModel
import ie.setu.artisan1.data.fakeItems
import ie.setu.artisan1.ui.theme.Artisan1Theme
import java.text.DateFormat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.offset
import androidx.compose.ui.unit.dp


@Composable
fun ItemCardList(
    products: List<ArtisanModel>,
    onDeleteProduct: (ArtisanModel) -> Unit,
    onClickProductDetails: (Int) -> Unit,
) {
    LazyColumn {
        items(
            items = products,
            key = { product -> product.id }
        ) { product ->
            var swipeOffset by remember { mutableStateOf(0f) }

            // 🔹 Animated offset with bounce-back effect
            val animatedOffset by animateFloatAsState(
                targetValue = swipeOffset,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy, // 🔹 Bounce effect
                    stiffness = Spring.StiffnessLow // 🔹 Smooth transition
                )
            )

            ItemCard(
                itemType = product.itemType,
                itemAmount = product.itemAmount,
                description = product.description,
                dateCreated = DateFormat.getDateTimeInstance().format(product.dateAdded),
                price = product.price,
                category = product.category,
                rating = product.rating,
                availability = product.availability,
                onClickDelete = { onDeleteProduct(product) },
                onClickProductDetails = { onClickProductDetails(product.id) },
                modifier = Modifier
                    .offset(x = animatedOffset.dp) // 🔹 Smoothly animate movement
                    .pointerInput(Unit) {
                        detectHorizontalDragGestures { _, dragAmount ->
                            swipeOffset += dragAmount
                            if (swipeOffset > 150f) {
                                swipeOffset = 0f // 🔹 Reset after action
                            } else if (swipeOffset < -150f) {
                                onDeleteProduct(product) // 🔹 Swipe left to delete
                                swipeOffset = 0f // 🔹 Reset after action
                            }
                        }
                    }
            )
        }
    }
}


@Preview(showBackground = true, wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE)
@Composable
fun ItemCardListPreview() {
    Artisan1Theme {
        ItemCardList(
            fakeItems.toMutableStateList(),
            onDeleteProduct = {},
            onClickProductDetails = {},
        )
    }
}
