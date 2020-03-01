package com.stbmorgan.movieinfoservice.rest;

import com.stbmorgan.movieinfoservice.entity.Movie;
import com.stbmorgan.movieinfoservice.entity.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private WebClient.Builder webClientBuilder;


    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
        MovieSummary movieSummary = webClientBuilder.build()
                .get()
                .uri("https://api.themoviedb.org/3/movie/"+movieId+"?api_key="+apiKey)
                .retrieve()
                .bodyToMono(MovieSummary.class)
                .block();
        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview() );
    }
}
