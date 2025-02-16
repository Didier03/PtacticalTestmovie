package com.example.practicaltestmovie

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import cafe.adriel.voyager.navigator.Navigator
import com.example.practicaltestmovie.View.LoginView
import com.example.practicaltestmovie.ViewModel.LoginViewModel
import com.example.practicaltestmovie.ui.theme.PracticalTestMovieTheme
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigator(screen = LoginView())
        }
    }
}
