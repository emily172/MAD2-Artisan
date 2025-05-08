package ie.setu.artisan1.ui.screens.record

import ie.setu.artisan1.ui.theme.Artisan1Theme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ie.setu.artisan1.R
import ie.setu.artisan1.data.ArtisanModel
import ie.setu.artisan1.data.fakeItems
import ie.setu.artisan1.ui.components.general.Centre
import ie.setu.artisan1.ui.components.record.ItemCardList
import ie.setu.artisan1.ui.components.record.RecordText

@Composable
fun RecordScreen(
    modifier: Modifier = Modifier,
    onClickProductDetails: (Int) -> Unit,
    recordViewModel: RecordViewModel = hiltViewModel()
) {
    //Setting up search for each product item on the list to filter
    var searchQuery by remember { mutableStateOf("") }
    val products = recordViewModel.uiProducts.collectAsState().value.filter {
        it.itemType.contains(searchQuery, ignoreCase = true) ||
                it.description.contains(searchQuery, ignoreCase = true) ||
                it.category.contains(searchQuery, ignoreCase = true)
    }

    Column {
        Column(
            modifier = modifier.padding(
                top = 48.dp,
                start = 24.dp,
                end = 24.dp
            ),
        ) {

            RecordText()
            //Display the item that is filtered by search outcome
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Search") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            if (products.isEmpty())
                Centre(Modifier.fillMaxSize()) {
                    Text(
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        lineHeight = 34.sp,
                        textAlign = TextAlign.Center,
                        text = stringResource(R.string.empty_list)
                    )
                }
            else
                ItemCardList(
                    products = products,
                    onClickProductDetails = onClickProductDetails,
                    onDeleteProduct = { product: ArtisanModel ->
                        recordViewModel.deleteProduct(product)
                    }
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecordScreenPreview() {
    Artisan1Theme {
        PreviewRecordScreen(
            modifier = Modifier,
            products = fakeItems.toMutableStateList()
        )
    }
}

@Composable
fun PreviewRecordScreen(
    modifier: Modifier = Modifier,
    products: SnapshotStateList<ArtisanModel>
) {
    Column {
        Column(
            modifier = modifier.padding(
                top = 48.dp,
                start = 24.dp,
                end = 24.dp
            ),
        ) {
            RecordText()
            if (products.isEmpty())
                Centre(Modifier.fillMaxSize()) {
                    Text(
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        lineHeight = 34.sp,
                        textAlign = TextAlign.Center,
                        text = stringResource(R.string.empty_list)
                    )
                }
            else
                ItemCardList(
                    products = products,
                    onDeleteProduct = {},
                    onClickProductDetails = {}
                )
        }
    }
}