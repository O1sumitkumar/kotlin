package com.example.learnkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.text
import androidx.compose.ui.tooling.preview.Preview
import com.example.learnkotlin.databinding.ActivityMainBinding
import com.example.learnkotlin.databinding.ActivitySecondBinding
import com.example.learnkotlin.ui.theme.LearnKotlinTheme

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)

//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        // this is good practice
//        setupDownloadButton()
//        setupUploadButton()
//        setupThemeButtons()
//        setupLoginButton()

        // here we will get the button with id
        val btnDownload = findViewById<Button>(R.id.btnDownload)
        val btnUpload = findViewById<Button>(R.id.btnUpload)
        btnDownload.setOnClickListener {
            // do something
            println("Download button clicked")
            Toast.makeText(this, "Download button clicked", Toast.LENGTH_SHORT).show()
        }
        btnUpload.setOnClickListener {
            // do something
            println("Upload button clicked")
            Toast.makeText(this, "Upload button clicked", Toast.LENGTH_SHORT).show()
        }

        // from here we are writing code for theme change

        val btnDark = findViewById<Button>(R.id.btnDarkMode)
        val btnLight = findViewById<Button>(R.id.btnLightMode)
        val themeStatus = findViewById<TextView>(R.id.themeStatus)

        // here we will set press event listener for both button
        btnDark.setOnClickListener{
            // change to dark mode

            println("Dark Mode button clicked")
            themeStatus.text = "Current App Theme is Dark Mode"
            Toast.makeText(this, "Dark Mode button clicked", Toast.LENGTH_SHORT).show()
        }
        btnLight.setOnClickListener{
            // do something
            println("Light Mode button clicked")
            themeStatus.text = "Current App Theme is Light Mode"
            Toast.makeText(this, "Light Mode button clicked", Toast.LENGTH_SHORT).show()
        }

        // from here we are writing code for login screen
        val  btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener{
            // do something
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            println("Login button clicked")
            Toast.makeText(this, "Login button clicked", Toast.LENGTH_SHORT).show()
        }

    }
    private fun setupDownloadButton() {
        binding.btnDownload.setOnClickListener {
            Log.d("MainActivity", "Download button clicked")
            Toast.makeText(this, "Download button clicked", Toast.LENGTH_SHORT).show()
        }

    }

    private fun setupUploadButton() {
        binding.btnUpload.setOnClickListener{
            Log.d("MainActivity", "Upload button clicked")
            Toast.makeText(this, "Upload button clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupThemeButtons() {
        binding.btnDarkMode.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            binding.themeStatus.text = "Current App Theme is Dark Mode"
        }

        binding.btnLightMode.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            binding.themeStatus.text = "Current App Theme is Light Mode"
        }
    }

    private fun setupLoginButton() {
        binding.btnLogin.setOnClickListener {
//            val intent = Intent(this, ActivitySecondBinding::class.java)
//            startActivity(intent)
        }
    }
}




@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnKotlinTheme {
        Greeting("Android")
    }
}