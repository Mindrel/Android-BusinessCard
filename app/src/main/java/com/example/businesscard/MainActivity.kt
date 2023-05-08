package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

// Complete app
@Composable
private fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF16233A))
    ) {
        Row(Modifier.weight(1f)) {  // Card owner with logo, name and sentence
            CardOwner(
                cardOwner = stringResource(R.string.card_owner),
                logo = painterResource(R.drawable.android_logo),
                ownerSentence = stringResource(R.string.owner_sentence),
                logoDescription = stringResource(R.string.content_description_logo)
            )
        }
        Divider()
        Row(Modifier.weight(0.3f)) { // // Contact detail rows
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                ContactDetail(
                    stringResource(R.string.phone),
                    Icons.Rounded.Phone,
                    stringResource(R.string.content_description_phone_icon)
                )
                ContactDetail(
                    stringResource(R.string.network),
                    Icons.Rounded.Share,
                    stringResource(R.string.content_description_share_icon)
                )
                ContactDetail(
                    stringResource(R.string.email_address),
                    Icons.Rounded.Email,
                    stringResource(R.string.content_description_email_icon)
                )
            }
        }
    }
}

// Contact detail rows
@Composable
private fun ContactDetail(text: String, icon: ImageVector, iconDescription: String) {
    Row(
        modifier = Modifier.padding(start = 40.dp, top = 10.dp, bottom = 10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = iconDescription,
            tint = Color(0xFF3DDC84),
        )
        Text(
            text = text,
            color = Color.White,
            modifier = Modifier.padding(start = 20.dp)
        )
    }
}

// Card owner with name, logo and sentence
@Composable
private fun CardOwner(
    cardOwner: String,
    logo: Painter,
    logoDescription: String,
    ownerSentence: String
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .padding(
                    bottom = 16.dp
                )
                .size(120.dp),
            painter = logo,
            contentDescription = logoDescription
        )
        Text(
            text = cardOwner,
            fontWeight = FontWeight.Bold,
            fontSize = 34.sp,
            color = Color.White
        )
        Text(
            text = ownerSentence,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color(0xFF3DDC84)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}