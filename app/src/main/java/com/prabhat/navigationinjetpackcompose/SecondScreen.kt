package com.prabhat.navigationinjetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController

@Composable
fun SecondScreen(navController: NavHostController, backStackEntry: NavBackStackEntry) {
    val url=backStackEntry.arguments?.getString("url")
    val counter=backStackEntry.arguments?.getInt("counter")
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Text(text = "Second Screen + $url  + $counter", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            navController.popBackStack()
            navController.navigate( Screen.Last.route)

        }) {

            Text(text = "Go to LAst screen")

        }
    }
}