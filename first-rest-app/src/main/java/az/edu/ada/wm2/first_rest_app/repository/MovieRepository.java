package az.edu.ada.wm2.first_rest_app.repository;

import az.edu.ada.wm2.first_rest_app.model.Movie;

import java.util.List;

public interface MovieRepository {

    List<Movie> findAll();

    Movie save(Movie  movie);

}
