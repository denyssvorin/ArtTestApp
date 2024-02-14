package com.example.arttestapp.ui.screen3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.arttestapp.R

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ThirdScreen(navController: NavController, viewModel: ThirdScreenViewModel = hiltViewModel()) {
    val userPreferences by viewModel.userPreferences.collectAsState()
    Row(
        modifier = Modifier
            .padding(8.dp)
    ) {
        GlideImage(
            model = "https://images.unsplash.com/photo-1706216282019-89761543ec0d?q=80&w=3088&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            contentDescription = stringResource(R.string.image),
            modifier = Modifier.size(150.dp).clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 8.dp)
        ) {
            UserName(name = userPreferences.name)
            UserAge(age = userPreferences.age)
        }
    }
}

@Composable
fun UserName(name: String) {
    Row(modifier = Modifier.padding(4.dp)) {
        Text(text = stringResource(id = R.string.name), fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.size(12.dp))
        Text(text = name)
    }
}

@Composable
fun UserAge(age: Int) {
    Row(modifier = Modifier.padding(4.dp)) {
        Text(text = stringResource(id = R.string.age), fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.size(12.dp))
        Text(text = age.toString())
    }
}
