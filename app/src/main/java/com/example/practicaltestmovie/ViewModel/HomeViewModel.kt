package com.example.practicaltestmovie.ViewModel

import com.example.practicaltestmovie.Models.Movie
import com.example.practicaltestmovie.Models.MovieResponse
import com.example.practicaltestmovie.Network.Network
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class HomeViewModel {
    suspend fun getNowPlayingMovies(): List<Movie> {
        val apiKey = "c0823934438075d63f1dbda4023e76fc"
        val response: HttpResponse = Network.httpClient.get("https://api.themoviedb.org/3/movie/now_playing?api_key=$apiKey&language=es-ES&page=1")
        return response.body<MovieResponse>().results
    }
    suspend fun getMovieDetails(movieId: Int): Movie {
        val apiKey = "c0823934438075d63f1dbda4023e76fc"
        val response: HttpResponse = Network.httpClient.get("https://api.themoviedb.org/3/movie/$movieId?api_key=$apiKey&language=es-ES")
        return response.body<Movie>()
    }
}