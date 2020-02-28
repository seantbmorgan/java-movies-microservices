package com.stbmorgan.moviecatalogservice.rest;

import com.stbmorgan.moviecatalogservice.entity.CatalogItem;
import com.stbmorgan.moviecatalogservice.entity.Movie;
import com.stbmorgan.moviecatalogservice.entity.Rating;
import com.stbmorgan.moviecatalogservice.entity.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    // @Autowired searches for bean type restTemplate
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        // Todo : need to update restTemplate to webClient

        // get all rated movie ids
        UserRating ratings = restTemplate.getForObject("http://movie-ratings-service/ratings/users/" + userId, UserRating.class);

        return ratings.getUserRating().stream().map(rating-> {
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), "Test", rating.getRating());
        }).collect(Collectors.toList());
        // foreach movie id, call movie info service and get details

        // merge the data
    }
}
