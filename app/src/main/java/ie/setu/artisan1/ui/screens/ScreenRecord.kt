package ie.setu.artisan1.ui.screens

import ie.setu.artisan1.ui.theme.Artisan1Theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ie.setu.artisan1.R
import ie.setu.artisan1.data.ArtisanModel
import ie.setu.artisan1.data.fakeItems
import ie.setu.artisan1.ui.components.general.Centre
import ie.setu.artisan1.ui.components.record.ItemCardList
import ie.setu.artisan1.ui.components.record.ItemCardList
import ie.setu.artisan1.ui.components.record.RecordText
import ie.setu.artisan1.ui.theme.Artisan1Theme

@Composable
fun ScreenReport(modifier: Modifier = Modifier,
                 items: SnapshotStateList<ArtisanModel>) {

    Column {
        Column(
            modifier = modifier.padding(
                top = 48.dp,
                start = 24.dp,
                end = 24.dp
            ),
        ) {
            RecordText()
            if(items.isEmpty())
            Centre(Modifier.fillMaxSize()) {
                Text(color = MaterialTheme.colorScheme.secondary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    lineHeight = 34.sp,
                    textAlign = TextAlign.Center,
                    text = stringResource(R.string.empty_list)
                )
            }
            else
            ItemCardList(
                items = items
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReportScreenPreview() {
    Artisan1Theme {
        ScreenReport( modifier = Modifier,
            items = fakeItems.toMutableStateList()
        )
    }
}
