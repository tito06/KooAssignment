package com.example.kooassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kooassignment.data.Data
import com.example.kooassignment.ui.theme.KooAssignmentTheme
import com.example.kooassignment.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KooAssignmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ItemList(dataList = mainViewModel.dataListResponse)
                    mainViewModel.getData()
                }
            }
        }
    }
}

@Composable
fun Item(data: Data) {
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp

    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(4.dp)
                .fillMaxHeight()
        ) {

            Text(
                text = data.title,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = data.body,
                style = MaterialTheme.typography.caption,
                modifier = Modifier
                    .padding(4.dp)
            )

        }

    }
}


@Composable
fun ItemList(dataList: List<Data>) {

    LazyColumn {
        itemsIndexed(items = dataList) { index, item ->
            Item(data = item)
        }
    }


}


