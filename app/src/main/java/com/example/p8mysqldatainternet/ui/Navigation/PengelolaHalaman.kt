package com.example.p8mysqldatainternet.ui.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.p8mysqldatainternet.ui.View.DestinasiEntry
import com.example.p8mysqldatainternet.ui.View.DestinasiHome
import com.example.p8mysqldatainternet.ui.View.EntryMhsScreen
import com.example.p8mysqldatainternet.ui.View.HomeScreen

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
                onDetailClick = {

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
    }
}