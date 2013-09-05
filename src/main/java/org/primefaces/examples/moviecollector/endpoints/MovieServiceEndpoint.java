package org.primefaces.examples.moviecollector.endpoints;

import java.math.BigInteger;

import org.primefaces.examples.moviecollector.service.MovieService;
import org.primefaces.examples.moviecollector.ws.EnumMovieFormat;
import org.primefaces.examples.moviecollector.ws.Movie;
import org.primefaces.examples.moviecollector.ws.movieservice.MovieDetailsRequest;
import org.primefaces.examples.moviecollector.ws.movieservice.MovieDetailsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * The Class MovieServiceEndpoint.
 */
@Endpoint
public class MovieServiceEndpoint {
	private static final String TARGET_NAMESPACE = "http://org/primefaces/examples/moviecollector/ws/movieservice";
	
	public static Logger LOGGER = LoggerFactory.getLogger(MovieServiceEndpoint.class);

	@Autowired
	private MovieService movieService;

	public void setMovieService(MovieService movieService) {
		this.movieService = movieService;
	}

	/**
	 * Gets the account details.
	 * 
	 * @param accountNumber
	 *            the account number
	 * @return the account details
	 */
	@PayloadRoot(localPart = "MovieDetailsRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload
	MovieDetailsResponse getMovieDetails(@RequestPayload MovieDetailsRequest request) {
		LOGGER.debug("getMovieDetails");
		MovieDetailsResponse response = new MovieDetailsResponse();

		/* call Spring injected service implementation to retrieve account data */
		org.primefaces.examples.moviecollector.domain.Movie persistentMovie = movieService.findById(request.getId()
				.longValue());
		Movie movie = buildMovie(persistentMovie);
		response.setMovieDetails(movie);
		return response;
	}

	/**
	 * 
	 * @param movie
	 */
	private Movie buildMovie(org.primefaces.examples.moviecollector.domain.Movie persistentMovie) {
		Movie movie = new Movie();
		movie.setMovieId(new BigInteger(persistentMovie.getId().toString()));
		movie.setMovieTitle(persistentMovie.getTitle());
		movie.setMovieDiscs(new BigInteger(persistentMovie.getDiscs().toString()));
		movie.setMovieDescription(persistentMovie.getDescription());
		movie.setMovieFormat(EnumMovieFormat.fromValue(persistentMovie.getFormat().name()));
		return movie;
	}

}