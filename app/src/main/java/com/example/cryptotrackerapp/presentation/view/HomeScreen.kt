package com.example.cryptotrackerapp.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cryptotrackerapp.presentation.viewmodel.DataViewModel

@Composable
fun HomeScreen(dataViewModel: DataViewModel = viewModel()) {

    val dataList by dataViewModel.dataList.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        dataViewModel.fetchData()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Market",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(20.dp)
        )

        LazyColumn(modifier = Modifier.fillMaxSize().padding(10.dp)) {
            items(dataList) { data ->
                Text(text = data.name)

            }
        }

    }
}


