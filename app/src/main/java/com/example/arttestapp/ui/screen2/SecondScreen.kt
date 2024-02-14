package com.example.arttestapp.ui.screen2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.arttestapp.R
import com.example.arttestapp.ui.ScreenNavigation

@Composable
fun SecondScreen(navController: NavController, viewModel: SecondScreenViewModel = hiltViewModel()) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        val numberPattern = remember { Regex("^\\d+\$") }

        TextField(
            modifier = Modifier.padding(16.dp),
            value = viewModel.userAge,
            onValueChange = { newValue ->
                if (newValue.isEmpty() || newValue.matches(numberPattern)) {
                    viewModel.updateUserAgeValue(newValue)
                }
            },
            label = { Text(stringResource(R.string.age)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )
        Button(onClick = { viewModel.saveUserAge() }) {
            Text(text = stringResource(R.string.save_age))
        }
        Button(onClick = { navController.navigate(ScreenNavigation.ThirdScreen.route) }) {
            Text(text = stringResource(R.string.next))
        }
    }
}