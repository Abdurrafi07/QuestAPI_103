package com.example.p8mysqldatainternet.ui.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.p8mysqldatainternet.ui.View.DestinasiDetail
import com.example.p8mysqldatainternet.ui.View.DestinasiEntry
import com.example.p8mysqldatainternet.ui.View.DestinasiHome
import com.example.p8mysqldatainternet.ui.View.DestinasiUpdate
import com.example.p8mysqldatainternet.ui.View.DetailScreen
import com.example.p8mysqldatainternet.ui.View.EntryMhsScreen
import com.example.p8mysqldatainternet.ui.View.HomeScreen
import com.example.p8mysqldatainternet.ui.View.UpdateScreen

@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController(),
                     modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = {
                    navController.navigate(DestinasiEntry.route)
                },
                onDetailClick = { nim ->
                    if (nim.isNotEmpty()){
                        navController.navigate("${DestinasiDetail.route}/$nim")
                    }

                }
            )
        }
        composable(DestinasiEntry.route) {
            EntryMhsScreen(
                navigateBack = {
                    navController.navigate(DestinasiHome.route) {
                        popUpTo(DestinasiHome.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(
            route = "${DestinasiDetail.route}/{nim}",
            arguments = listOf(navArgument("nim") { type = NavType.StringType })
        ) { backStackEntry ->
            val nim = backStackEntry.arguments?.getString("nim") ?: ""
            DetailScreen(
                nim = nim,
                navigateBack = {
                    navController.navigate(DestinasiHome.route) {
                        popUpTo(DestinasiHome.route) {
                            inclusive = true
                        }
                    }
                },
                onClick = {
                    navController.navigate("${DestinasiUpdate.route}/$nim")
                }
            )
        }

        composable(
            route = "${DestinasiUpdate.route}/{nim}",
            arguments = listOf(navArgument("nim") { type = NavType.StringType })
        ) { backStackEntry ->
            val nim = backStackEntry.arguments?.getString("nim") ?: ""
            UpdateScreen(
                nim = nim,
                navigateBack = {
                    navController.navigate(DestinasiHome.route) {
                        popUpTo(DestinasiHome.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}