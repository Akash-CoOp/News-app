package com.example.demonewsapp.ui.components

import android.graphics.ColorSpace.Model
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableOpenTarget
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.demonewsapp.R
import com.example.demonewsapp.R.drawable.newsapplogo
import com.example.demonewsapp.data.entities.Article
import com.example.demonewsapp.data.entities.NewsResponseData
import com.example.demonewsapp.ui.theme.Purple40


@Composable
fun Loader(){
Column(modifier = Modifier.fillMaxSize()
    .padding(10.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center) {  }
    CircularProgressIndicator(modifier = Modifier
        .size(70.dp)
        .padding(10.dp)
        ,color= Purple40)
}
@Composable

fun NewsList( responseData: NewsResponseData){
    LazyColumn {
        items(responseData.articles){article->
            NormalText(textValue = article.title?:"NA")

        }
    }
}
@Composable
fun NormalText(textValue:String){
    Text(modifier=Modifier
        .fillMaxWidth()
        .wrapContentHeight( )
        .padding(10.dp),
        text = textValue,
        color = Purple40,
        style= TextStyle(fontSize = 18.sp
            , fontWeight = FontWeight.Normal)

    )

}
@Composable
fun NewsRowComponent(page:Int,article:Article){
    Column (
        modifier = Modifier.fillMaxSize()
            .padding(8.dp)
            .background(color = Color.White)
    ){
        AsyncImage(modifier = Modifier.padding(20.dp).clip(shape = RoundedCornerShape(5))
            .fillMaxWidth().height(300.dp), model =  article.urlToImage, contentDescription = null,contentScale= ContentScale.Crop
        ,placeholder = painterResource(id=R.drawable.newsapplogo), error = painterResource(newsapplogo)
        )
        Spacer(modifier = Modifier.size(20.dp))

        TitleText(textValue = article.title)
         Spacer(modifier = Modifier.size(10.dp))
        NormalText(textValue = article.description?:"")
        Spacer(modifier = Modifier.weight(1f))
        AuthorDetails(article.author?:"NA", article.source.name)
    }



}
@Composable
fun TitleText(textValue: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp),
        text = textValue,
        style = TextStyle(
            fontSize = 24.sp, // Bigger title
            fontWeight = FontWeight.Bold,
            color = Color.Magenta
        )
    )
}
@Composable
fun AuthorDetails(authorName:String="", sourceName:String=""){
    Row(modifier = Modifier
        .fillMaxWidth().padding(start = 10.dp, end = 10.dp, bottom = 20.dp)
    ) {
        Text(authorName)
        Spacer(modifier =   Modifier.weight(1f))
       Text(sourceName)


    }
}

