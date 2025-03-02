package ie.setu.artisan1.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ie.setu.artisan1.data.ArtisanModel
import ie.setu.artisan1.ui.screens.ScreenItem
import ie.setu.artisan1.ui.screens.ScreenReport
import ie.setu.artisan1.ui.screens.ScreenAbout

@Composable
fun NavHostProvider(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    paddingValues: PaddingValues,
    items: SnapshotStateList<ArtisanModel>
) {
    NavHost(
        navController = navController,
        startDestination = Record.route,
        modifier = modifier.padding(paddingValues = paddingValues)
    ) {
        composable(route = Item.route) {
            // Call our 'Item' Screen Here
            ScreenItem(modifier = modifier, items = items)
        }
        composable(route = Record.route) {
            // Call our 'Record' Screen Here
            ScreenReport(modifier = modifier, items = items)
        }
        composable(route = About.route) {
            //call our 'About' Screen Here
            ScreenAbout(modifier = modifier)
        }

    }
}
