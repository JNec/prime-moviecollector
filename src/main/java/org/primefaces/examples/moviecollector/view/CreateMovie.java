package org.primefaces.examples.moviecollector.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.examples.moviecollector.domain.Movie;
import org.primefaces.examples.moviecollector.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("createMovie")
@Scope("request")
public class CreateMovie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4700369992893894896L;

	private static final Logger LOGGER = LoggerFactory.getLogger(CreateMovie.class);

	private Movie movie = new Movie();

	private MovieService movieService;

	public CreateMovie() {
	}

	@Autowired
	public CreateMovie(MovieService movieService) {
		LOGGER.debug("CreateMovie...");
		this.movieService = movieService;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public void save(ActionEvent actionEvent) {
		LOGGER.debug("save...");
		movieService.createNew(movie);
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Movie is saved");
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		movie = new Movie();
	}
}