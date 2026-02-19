package az.edu.ada.wm2.first_rest_app.service;

import az.edu.ada.wm2.first_rest_app.model.Movie;
import az.edu.ada.wm2.first_rest_app.repository.MovieRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepo;

    public MovieServiceImpl(MovieRepository movieRepo) {
        this.movieRepo = movieRepo;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    @Override
    public Movie create(Movie movie) {
        return movieRepo.save(movie);
    }
}
