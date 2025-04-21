package com.example.utilities
import android.Manifest
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.annotation.RequiresPermission

object coreUtilities {


    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    fun isInternetConnected(context: Context): Boolean {
        // Step 1: Get the ConnectivityManager
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // Step 2: Get the active network
        val networkCapabilities = connectivityManager.activeNetwork ?: return false

        // Step 3: Get the network capabilities of the active network
        val actNw = connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false

        // Step 4: Check if the active network supports any valid transport type
        val result = when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }

        // Step 5: Return the result
        return result
    }
}