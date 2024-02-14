package com.example.arttestapp.ui.screen1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.arttestapp.R
import com.example.arttestapp.ui.ScreenNavigation

@Composable
fun FirstScreen(navController: NavController, viewModel: FirstScreenViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            modifier = Modifier.padding(16.dp),
            value = viewModel.userName,
            onValueChange = { newValue ->
                viewModel.updateUserNameValue(newValue)
            },
            label = { Text(stringResource(R.string.name)) },
        )
        Button(onClick = { viewModel.saveUserName() }) {
            Text(text = stringResource(R.string.save_name))
        }
        Button(onClick = { navController.navigate(ScreenNavigation.SecondScreen.route) }) {
            Text(text = stringResource(R.string.next))
        }
    }
}