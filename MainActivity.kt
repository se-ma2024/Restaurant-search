package com.example.restaurantsearch

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.restaurantsearch.data.Location.com.example.restaurantsearch.data.Location.LocationSensor
import com.example.restaurantsearch.navigation.MainNavHost
import com.example.restaurantsearch.screen.SearchScreen.SearchScreen
import com.example.restaurantsearch.ui.theme.RestaurantSearchTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var locationSensor: LocationSensor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RestaurantSearchTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainNavHost(navController)
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        locationSensor = LocationSensor(this)
        locationSensor.requestLocationPermission(this)

        locationSensor.location.observe(this, Observer { location ->
            Log.d(
                "LocationSensor",
                "Latitude: ${location.latitude}, Longitude: ${location.longitude}"
            )
            viewModel.updateLocation(location.latitude, location.longitude)
        })
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            locationSensor.fusedLocation()
        } else {
            // 権限がない場合、リクエスト
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                1001
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RestaurantSearchTheme {
        val navController: NavHostController = rememberNavController()
        SearchScreen(navController = navController)
    }
}