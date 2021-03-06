package org.primefaces.examples.moviecollector.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.primefaces.examples.moviecollector.domain.Movie;
import org.primefaces.examples.moviecollector.domain.MyLazyDataModel;
import org.primefaces.examples.moviecollector.service.MovieService;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("manageMovies")
@Scope("session")
public class ManageMovies implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3578027369860883126L;
	
	private LazyDataModel<Movie> movies;
	private MovieService movieService;
	private String title;
	private Movie[] selectedMovies;

	@Autowired
	public ManageMovies(MovieService movieService) {
		this.movieService = movieService;
		movies = new MyLazyDataModel(movieService);
	}

	public LazyDataModel<Movie> getMovies() {
		return movies;
	}

	public void setMovies(LazyDataModel<Movie> movies) {
		this.movies = movies;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Movie[] getSelectedMovies() {
		return selectedMovies;
	}

	public void setSelectedMovies(Movie[] selectedMovies) {
		this.selectedMovies = selectedMovies;
	}

	public List<String> getMoviesByTitle(String title) {
		List<Movie> foundMovies = movieService.findByTitle(title);
		List<String> titles = new ArrayList<String>();

		for (Movie m : foundMovies) {
			titles.add(m.getTitle());
		}

		return titles;
	}

	public void search(ActionEvent actionEvent) {
		movies.load(0, 10, null, SortOrder.UNSORTED, new HashMap<String, String>() {
			{
				put("title", getTitle());
			}
		});
	}
}