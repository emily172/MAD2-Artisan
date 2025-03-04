package ie.setu.artisan1.ui.screens.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ie.setu.artisan1.data.ArtisanModel
import ie.setu.artisan1.data.fakeItems
import ie.setu.artisan1.ui.components.item.AmountPicker
import ie.setu.artisan1.ui.components.item.HomeText
import ie.setu.artisan1.ui.components.item.ItemButton
import ie.setu.artisan1.ui.components.item.ItemInventory
import ie.setu.artisan1.ui.components.item.RadioButtonGroup
import ie.setu.artisan1.ui.components.item.ItemDescription
import ie.setu.artisan1.ui.theme.Artisan1Theme

@Composable
fun ItemScreen(modifier: Modifier = Modifier,
               items: SnapshotStateList<ArtisanModel>) {

    var itemType by remember { mutableStateOf("Soap") }
    var itemAmount by remember { mutableIntStateOf(10) }
    var itemDescription by remember { mutableStateOf("Add an item description!") }
    var totalItems by remember { mutableIntStateOf(0) }

    totalItems = items.sumOf { it.itemAmount }
    //Adding in the scrolling
    Column {
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 16.dp),
                 verticalArrangement = Arrangement.spacedBy(30.dp),
        ) {
            HomeText()
            Row(
                verticalAlignment = Alignment.CenterVertically,
            )
            {
                RadioButtonGroup(
                    modifier = modifier,
                    onCategoryChange = { itemType = it }
                )
                Spacer(modifier.weight(1f))
                AmountPicker(
                    onCategoryChange = { itemAmount = it }
                )
            }
            ItemInventory(
                modifier = modifier,
                totalItems = totalItems
            )
            ItemDescription(
                modifier = modifier,
                onDescriptionChange = { itemDescription = it }
            )

            ItemButton (
                modifier = modifier,
                item = ArtisanModel(itemType = itemType,
                    itemAmount = itemAmount,
                    description = itemDescription),
                items = items,
                onTotalItemsChange = { totalItems = it }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemScreenPreview() {
    Artisan1Theme {
        ItemScreen( modifier = Modifier,
            items = fakeItems.toMutableStateList())
    }
}