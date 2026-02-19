package az.edu.ada.wm2.first_rest_app.service;

import az.edu.ada.wm2.first_rest_app.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();

    Movie create(Movie movie);

}
