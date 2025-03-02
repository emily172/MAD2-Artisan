package ie.setu.artisan1.ui.components.record

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import ie.setu.artisan1.data.ArtisanModel
import ie.setu.artisan1.data.fakeItems
import ie.setu.artisan1.ui.theme.Artisan1Theme
import java.text.DateFormat


@Composable
internal fun ItemCardList(
    items: SnapshotStateList<ArtisanModel>,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(
            items = items,
            key = { item -> item.id }
        ) { item ->
            ItemCard(
                itemType = item.itemType,
                itemAmount = item.itemAmount,
                description = item.description,
                dateCreated = DateFormat.getDateTimeInstance().format(item.dateAdded),
            )
        }
    }
}

@Preview(showBackground = true,
    wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE
)
@Composable
fun ItemCardListPreview() {
    Artisan1Theme {
        ItemCardList(fakeItems.toMutableStateList())
    }
}
