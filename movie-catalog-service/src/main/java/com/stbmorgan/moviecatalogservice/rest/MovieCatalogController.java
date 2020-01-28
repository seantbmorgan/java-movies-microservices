package com.stbmorgan.moviecatalogservice.rest;

import com.stbmorgan.moviecatalogservice.entity.CatalogItem;
import com.stbmorgan.moviecatalogservice.entity.Rating;
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

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        // return Collections.singletonList(new CatalogItem("Transformers", "Test", 4));

        RestTemplate restTemplate = new RestTemplate();

        // get all rated movie ids
        List<Rating> ratings = Arrays.asList(
                new Rating("1234",4), new Rating("5678",7), new Rating("9876",44));

        return ratings.stream().map(rating-> {
            new CatalogItem("Transformers", "Test", 4);
        }).collect(Collectors.toList())
        // foreach movie id, call movie info service and get details

        // merge the data
    }
}
