package com.alibaihaqi.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alibaihaqi.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardWrapper(
                        name = "Jennifer Doe",
                        role = "Android Developer Extraordinaire",
                        phone = "+11 (123) 444 555 666",
                        profile = "@AndroidDev",
                        email = "jen.doe@android.com"
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCardWrapper(
    name: String,
    role: String,
    phone: String,
    profile: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(Color(0xFF1DB954))
            .fillMaxSize()
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.75F),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            MainInfoCard(name, role)
        }
        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Column {
                PersonalInfoCard(Icons.Default.Phone, phone)
                PersonalInfoCard(Icons.Default.Share, profile)
                PersonalInfoCard(Icons.Default.Email, email)

            }
        }
    }
}

@Composable
fun MainInfoCard (name: String, role: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.android_logo)
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box (
            modifier = Modifier
                .background(Color(0xFF003700))
                .fillMaxWidth(0.3F)
        ) {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
        }
        Text(
            color = Color.White,
            fontSize = 32.sp,
            text = name,
            modifier = modifier
                .padding(top = 16.dp, bottom = 8.dp),
        )
        Text(
            color = Color(0xFF003700),
            text = role,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun PersonalInfoCard (icon: ImageVector, title: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(top = 4.dp, bottom = 4.dp)
    ) {
        Icon(
            icon,
            contentDescription = title,
            tint = Color(0xFF003700)
        )
        Text(
            color = Color.White,
            fontSize = 12.sp,
            text = title,
            modifier = modifier
                .padding(start = 20.dp),
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
        BusinessCardWrapper(
            name = "Jennifer Doe",
            role = "Android Developer Extraordinaire",
            phone = "+11 (123) 444 555 666",
            profile = "@AndroidDev",
            email = "jen.doe@android.com"
        )
    }
}