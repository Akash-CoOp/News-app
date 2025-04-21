package com.example.demonewsapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.example.demonewsapp.ui.HomeScreen


@Composable
fun AppNavigationGraph(){
    val navController = rememberNavController()
  NavHost(navController = navController, startDestination = "home") {
      composable("home"){
          HomeScreen()
      }
  }
}