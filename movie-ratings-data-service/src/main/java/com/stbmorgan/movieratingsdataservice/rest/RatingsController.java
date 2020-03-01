package com.stbmorgan.movieratingsdataservice.rest;

import com.stbmorgan.movieratingsdataservice.entity.Rating;
import com.stbmorgan.movieratingsdataservice.entity.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId, 4);
    }

    /**
     *
     * @param userId
     * @return Provides object with property 'userRating' revealing a list of users ratings
     */
    @RequestMapping("users/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId){
        List<Rating> ratings = Arrays.asList(
                new Rating("550",3),
                new Rating("460",6),
                new Rating("380",7)
        );
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }
}
