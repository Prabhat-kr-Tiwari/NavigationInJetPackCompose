package com.prabhat.navigationinjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.prabhat.navigationinjetpackcompose.ui.theme.NavigationInJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationInJetPackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    val paddingvalues=it
                    val navController= rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.Home.route) {
                        composable( Screen.Home.route){
                            HomeScreen(navController = navController)
                        }
                        composable(
                            Screen.Second.route+"/{url}/{counter}",
                            arguments = listOf(
                                navArgument("url"){type= NavType.StringType },
                                navArgument("counter"){type= NavType.IntType }


                            )

                            ){backStackEntry->
//                            val url=backStackEntry.arguments?.getString("url")
                            SecondScreen(backStackEntry = backStackEntry, navController = navController)
                        }
                        composable( Screen.Last.route){
                            LastScreen(navController = navController)
                        }

                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavigationInJetPackComposeTheme {
        Greeting("Android")
    }
}