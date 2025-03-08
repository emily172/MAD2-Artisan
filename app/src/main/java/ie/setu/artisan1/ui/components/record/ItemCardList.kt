package ie.setu.artisan1.ui.components.record

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import ie.setu.artisan1.data.ArtisanModel
import ie.setu.artisan1.data.fakeItems
import ie.setu.artisan1.ui.theme.Artisan1Theme
import java.text.DateFormat

@Composable
fun ItemCardList(
    products: List<ArtisanModel>,
    onDeleteProduct: (ArtisanModel) -> Unit,
    onClickProductDetails: (Int) -> Unit
) {
    LazyColumn {
        items(
            items = products,
            key = { product -> product.id } // Unique key for each item
        ) { product ->
            ItemCard(
                itemType = product.itemType,
                itemAmount = product.itemAmount,
                description = product.description,
                dateCreated = DateFormat.getDateTimeInstance().format(product.dateAdded),
                onClickDelete = { onDeleteProduct(product) },
                onClickProductDetails = { onClickProductDetails(product.id) }
            )
        }
    }
}

@Preview(showBackground = true,
    wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE)

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
