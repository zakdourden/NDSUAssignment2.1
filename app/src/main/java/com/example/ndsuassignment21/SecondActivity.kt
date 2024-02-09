package com.example.ndsuassignment21
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ndsuassignment21.ui.theme.NDSUAssignment21Theme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NDSUAssignment21Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ExplicitContent()
                }
            }
        }
    }

    @Composable
    private fun ExplicitContent() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,  // Center text horizontally
            verticalArrangement = Arrangement.Center  // Center text vertically
        ) {
            Text("Nicholas Jenson")
            Text("NDSU ID: 1385647")
            Spacer(modifier = Modifier.fillMaxWidth().padding(16.dp))
            Text("Challenges in Mobile Software Engineering:")
            Spacer(modifier = Modifier.fillMaxWidth().padding(16.dp))
            Text(getString(R.string.challenge_1_text))
            Text(getString(R.string.challenge_2_text))
            Text(getString(R.string.challenge_3_text))
            Text(getString(R.string.challenge_4_text))
            Text(getString(R.string.challenge_5_text))
            Spacer(modifier = Modifier.fillMaxWidth().padding(16.dp))
            Image(
                painter = painterResource(R.drawable.baseline_castle_24),  // Replace with your image name
                contentDescription = "Castle logo"  // Accessibility description
            )
            Button(
                onClick = { goHome() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Back to Home")
            }
        }
    }

    private fun goHome() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}



