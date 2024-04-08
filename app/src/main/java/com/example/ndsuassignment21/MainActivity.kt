package com.example.ndsuassignment21
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ndsuassignment21.ui.theme.NDSUAssignment21Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NDSUAssignment21Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TwoButtonLayout()
                }
            }
        }
    }

    @Composable
    fun TwoButtonLayout() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,  // Center text horizontally
            verticalArrangement = Arrangement.Center
        ) {
            Text("Nicholas Jenson")
            Text("NDSU ID: 1385647")
            Button(
                onClick = { thirdActivityClick() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("View Image Activity")
            }
            Button(
                onClick = { explicitActivityClick() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Start Activity Explicitly")
            }
            Button(
                onClick = { implicitActivityClick() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Start Activity Implicitly")
            }
        }
    }

    private fun thirdActivityClick() {
        Intent (this, ThirdActivity::class.java).also {
            startActivity(it)
        }
    }

    private fun explicitActivityClick() {
        Intent (this, SecondActivity::class.java).also {
            startActivity(it)
        }
    }

    // I wasnt able to get any of my solutions or the ones I found in the slide to work
    // Credit for this code working goes to: https://stackoverflow.com/questions/60056522/use-implicit-intent-to-launch-another-activity-in-the-same-app
    private fun implicitActivityClick() {
        val sendIntent = Intent().apply {
            action = "android.intent.action.OPEN_SECOND_ACTIVITY"
            type = "text/plain"
            putExtra("EXTRA_KEY","some argument I want to pass as an Extra")
        }
        if (sendIntent.resolveActivity(packageManager) != null) {
            startActivity(sendIntent)
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewTwoButtonLayout() {
        NDSUAssignment21Theme {
            TwoButtonLayout()
        }
    }
}
