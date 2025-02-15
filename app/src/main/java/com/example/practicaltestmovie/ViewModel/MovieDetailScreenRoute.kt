package com.example.practicaltestmovie.ViewModel

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import com.example.practicaltestmovie.Models.Movie
import com.example.practicaltestmovie.View.MovieDetailScreen
import kotlinx.coroutines.launch

data class MovieDetailScreenRoute(val movieId: Int) : Screen {
    @Composable
    override fun Content() {
        // Aquí deberías obtener la película según el `movieId` que recibas
        val movieService = remember { HomeViewModel() }
        var movie by remember { mutableStateOf<Movie?>(null) }
        val coroutineScope = rememberCoroutineScope()

        LaunchedEffect(movieId) {
            coroutineScope.launch {
                movie = movieService.getMovieDetails(movieId) // Implementa este método en tu ViewModel
            }
        }

        movie?.let {
            MovieDetailScreen(it)
        } ?: CircularProgressIndicator() // Muestra un loader mientras carga
    }
}
