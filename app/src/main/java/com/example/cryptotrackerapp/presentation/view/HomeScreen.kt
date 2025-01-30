package com.example.cryptotrackerapp.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.cryptotrackerapp.presentation.viewmodel.DataViewModel

@Composable
fun HomeScreen(dataViewModel: DataViewModel = viewModel()) {

    val dataList by dataViewModel.dataList.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Market",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(30.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            items(dataList) { data ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter("https://s2.coinmarketcap.com/static/img/coins/64x64/${data.id}.png"),
                            contentDescription = "Icon",
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = data.name,
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(
                                text = data.symbol,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }

                    Column(horizontalAlignment = Alignment.End) {
                        Text(
                            text = String.format("$%.2f", data.quote.USD.price),
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = String.format("%.2f%%", data.quote.USD.percent_change_24h),
                            color = if (data.quote.USD.percent_change_24h > 0) Color.Green else Color.Red,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
                Divider()
            }
        }

    }
}


