package az.edu.ada.wm2.first_rest_app.repository;

import az.edu.ada.wm2.first_rest_app.model.Movie;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
    private List<Movie> movieList = new ArrayList<>(List.of(
            new Movie(1, "Inception", "Sci-Fi", 9.3),
            new Movie(2, "Arrival", "Sci-Fi", 9.5),
            new Movie(3, "Fight Club", "Action", 8.7)
    ));

    @Override
    public List<Movie> findAll() {
        return movieList ;
    }

    @Override
    public Movie save(Movie movie) {
        if(movie == null) return null;

        movie.setCreateAt(LocalDateTime.now());
        movieList.add(movie);

        return movie;
    }

    public Optional<Movie> getById(int id){

        return Optional.empty();
    }
}
