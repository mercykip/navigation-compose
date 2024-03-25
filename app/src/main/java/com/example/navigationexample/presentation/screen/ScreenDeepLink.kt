package com.example.navigationexample.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ScreenDeepLink(navController: NavController, value: String?) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Screen Three")
        Text(text = "Value passed using deeplink :: $value")
        Spacer(modifier = Modifier.height(60.dp))
        Button(
            onClick = {
                navController.navigate("screentwo")
            },
            modifier = Modifier.width(300.dp)
        ) {
            Text(text = "Screen two", fontSize = 10.sp)
        }
    }


}