package com.cg.cloud.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.cg.cloud.moviecatalogservice.models.CatalogItem;
import com.cg.cloud.moviecatalogservice.models.Movie;
import com.cg.cloud.moviecatalogservice.models.Rating;
import com.cg.cloud.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;

//	@Autowired
//	private WebClient.Builder webClientBuilder;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		// get all rated movie IDs
		UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/" + userId,
				UserRating.class);

		// For Each movie ID, call movie info service ad get details
		return ratings.getUserRating().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);

//			Movie movie = webClientBuilder.build()
//					.get()
//					.uri("http://localhost:8082/movies/" + rating.getMovieId())
//					.retrieve()
//					.bodyToMono(Movie.class)
//					.block();

			return new CatalogItem(movie.getName(), "Test", rating.getRating());
		}).collect(Collectors.toList());

		// Put them all together

//		return Collections.singletonList(new CatalogItem("Bumblebee", "Test", 4));

	}
}
