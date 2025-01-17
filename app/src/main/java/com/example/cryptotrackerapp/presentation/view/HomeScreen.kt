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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cryptotrackerapp.data.model.Currency
import com.example.cryptotrackerapp.presentation.viewmodel.CurrencyDataViewModel

@Composable
fun HomeScreen(currencyDataViewModel: CurrencyDataViewModel = viewModel()) {
    val currencyList = currencyDataViewModel.currencyList.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        currencyDataViewModel.fetchData()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Market",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(currencyList.value) { currency ->
                CurrencyListItem(currency)

            }

        }

    }
}

@Composable
fun CurrencyListItem(currency: Currency) {
    Column(modifier = Modifier.fillMaxSize()) {
//        Icon()
        Text(
            text = currency.name,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(8.dp)
        )
    }

}
