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
import ie.setu.artisan1.ui.screens.item.ItemScreen
import ie.setu.artisan1.ui.screens.record.RecordScreen
import ie.setu.artisan1.ui.screens.about.AboutScreen
import ie.setu.artisan1.ui.screens.details.DetailsScreen

@Composable
fun NavHostProvider(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    paddingValues: PaddingValues,
    products: SnapshotStateList<ArtisanModel>
) {
    NavHost(
        navController = navController,
        startDestination = Record.route,
        modifier = modifier.padding(paddingValues = paddingValues)
    ) {
        composable(route = Item.route) {
            // Call our 'Item' Screen Here
            ItemScreen(modifier = modifier)
        }
        composable(route = Record.route) {
            //call our 'Record' Screen Here
            RecordScreen(
                modifier = modifier,
                onClickProductDetails = { productId: Int ->
                    navController.navigateToProductDetails(productId)
                },
            )
        }

        composable(route = About.route) {
            //call our 'About' Screen Here
            AboutScreen(modifier = modifier)
        }

        composable(
            route = Details.route,
            arguments = Details.arguments
        )
        { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getInt(Details.idArg)
            if (id != null) {
                DetailsScreen()
            }
        }

    }

}

private fun NavHostController.navigateToProductDetails(artisanId: Int) {
    this.navigate("details/$artisanId")
}
