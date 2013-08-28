package org.primefaces.examples.moviecollector.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.examples.moviecollector.domain.Movie;
import org.primefaces.examples.moviecollector.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("viewMovie")
@Scope("view")
public class ViewMovie implements Serializable {

    private Movie movie;
    private MovieService movieService;
    private Long movieId;

    public Long getMovieId() {
        return movieId;
    }

    public ViewMovie() {
    }

    @Autowired
    public ViewMovie(MovieService movieService) {
        this.movieService = movieService;
    }

    public void onLoad() {
        movie = movieService.findById(movieId);
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void update() {
        movieService.update(movie);
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Movie is updated successfully", "OK");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }

    public String remove() {
        movieService.remove(movie);

        return "manageMovies?faces-redirect=true";
    }
}
