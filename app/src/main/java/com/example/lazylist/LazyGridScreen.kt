package com.example.lazylist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.lazylist.model.Item


@Composable
fun LazyGridScreen() {

    LazyVerticalGrid (
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 16.dp),
        columns = GridCells.Adaptive(160.dp)
    ) {

        itemsIndexed(MainActivity.imageList) { index, item ->
            Spacer(modifier = Modifier.height(8.dp))
            GridItem(item)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}


@Composable
fun GridItem(item: Item) {
    Column(
        modifier = Modifier
            .height(250.dp)
            .width(200.dp).padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(30.dp)),
            painter = painterResource(id = item.image),
            contentDescription = item.title,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = item.title, fontWeight = FontWeight.SemiBold)
    }
}