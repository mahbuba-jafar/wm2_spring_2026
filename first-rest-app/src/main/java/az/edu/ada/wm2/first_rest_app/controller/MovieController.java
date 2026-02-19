package az.edu.ada.wm2.first_rest_app.controller;

import az.edu.ada.wm2.first_rest_app.model.Movie;
import az.edu.ada.wm2.first_rest_app.service.AuthorService;
import az.edu.ada.wm2.first_rest_app.service.MovieService;
import az.edu.ada.wm2.first_rest_app.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    //    @Autowired //Field Injections
    private MovieService movieService;

    private AuthorService authorService;

    @Value("${my.welcome.message}")
    private String welcomeMessage;

    //    @Autowired
    public MovieController(MovieService movieService, AuthorService authorService) {
        this.movieService = movieService;
        this.authorService = authorService;
    }

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping({"", "/"})
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/hi")
    public String sayHello() {
        return welcomeMessage;
    }

    @PostMapping
    public Movie createMovie( @RequestBody Movie movie) {
        System.out.println(movie);
        return movieService.create(movie);
    }

}
