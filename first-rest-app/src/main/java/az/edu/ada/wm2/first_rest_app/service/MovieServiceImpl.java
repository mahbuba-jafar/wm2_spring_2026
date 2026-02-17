package az.edu.ada.wm2.first_rest_app.service;

import az.edu.ada.wm2.first_rest_app.model.Movie;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    List<Movie> movieList = new ArrayList<>(List.of(
            new Movie(1, "Inception", "Sci-Fi", 9.3),
            new Movie(2, "Arrival", "Sci-Fi", 9.5),
            new Movie(3, "Fight Club", "Action", 8.7)
    ));

    @Override
    public List<Movie> getAllMovies() {
        return movieList;
    }
}
