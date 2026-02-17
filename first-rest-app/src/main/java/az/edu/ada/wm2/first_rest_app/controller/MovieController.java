package az.edu.ada.wm2.first_rest_app.controller;

import az.edu.ada.wm2.first_rest_app.model.Movie;
import az.edu.ada.wm2.first_rest_app.service.MovieService;
import az.edu.ada.wm2.first_rest_app.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

//    @Autowired //Field Injections
    private MovieService movieService;

//    @Autowired
//    public MovieController(MovieService movieService) {
//        this.movieService = movieService;
//    }

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping({"", "/"})
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

}
