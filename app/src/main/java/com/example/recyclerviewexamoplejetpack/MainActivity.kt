package com.example.recyclerviewexamoplejetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recyclerviewexamoplejetpack.ui.theme.RecyclerViewExamopleJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecyclerViewExamopleJetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DetailsContent()
                }
            }
        }
    }
}


@Composable
fun DetailsContent() {

    val employees = remember { Details.EmployDetailsList }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            employees
        ) {
            EmployeeCard(emp = it)
        }
    }
}



@Composable
fun EmployeeCard(emp: EmployDetails) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = Color.Gray,
        //shape = CircleShape
        shape = RoundedCornerShape(corner = CornerSize(20.dp))

    ) {

        Row(modifier = Modifier.padding(20.dp)) {
            Column(modifier = Modifier.weight(1f),
                Arrangement.Center) {
                Text(
                    text = emp.title,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Text(
                    text = "Age :- "+emp.age.toString(),
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 15.sp
                    )
                )
                Text(
                    text = "Sex :- "+emp.sex,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 15.sp
                    )
                )

                Text(
                    text = "Description :- "+emp.description,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 15.sp
                    )
                )
            }
           Image(painter = painterResource(emp.ImageId), contentDescription = "Profile Image",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .padding(8.dp)
                    .size(110.dp)
                    .clip((CircleShape)  ))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RecyclerViewExamopleJetpackTheme {
        DetailsContent()
    }
}