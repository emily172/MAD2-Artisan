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
import ie.setu.artisan1.ui.screens.auth.LoginScreen
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
        startDestination = "login_screen", // ✅ Set LoginScreen as the first screen
        modifier = modifier.padding(paddingValues = paddingValues)
    ) {
        composable(route = "login_screen") {
            LoginScreen(navController = navController, onLoginSuccess = { navController.navigate("record_screen") })
        }


        composable(route = Record.route) {
            RecordScreen(
                modifier = modifier,
                onClickProductDetails = { productId: Int ->
                    navController.navigateToProductDetails(productId)
                },
            )
        }

        composable(route = Item.route) {
            ItemScreen(modifier = modifier)
        }

        composable(route = About.route) {
            AboutScreen(modifier = modifier)
        }

        composable(
            route = Details.route,
            arguments = Details.arguments
        ) { navBackStackEntry ->
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
