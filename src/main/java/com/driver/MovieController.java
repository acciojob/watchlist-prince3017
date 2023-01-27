package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity("New Movie Added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("New Director Added Successfully",HttpStatus.CREATED);
    }
    @PostMapping("/movies/add-movie-director-pair")
    public ResponseEntity addDirectorPair(@RequestParam("Moviename") String movie, @RequestParam("Directorname") String director ){
        String response = movieService.pairDirectorMovie(movie,director);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name){
        Movie mo = movieService.getMovieByName(name);
        return new ResponseEntity<>(mo,HttpStatus.CREATED);
    }
    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name){
        Director di = movieService.getDirectorByName(name);
        return new ResponseEntity<>(di,HttpStatus.CREATED);
    }
    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String director){
        List<String> movielist = movieService.getMoviesByDirectorName(director);
        return new ResponseEntity<>(movielist,HttpStatus.CREATED);
    }
    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> allMovies= movieService.findAllMovies();
        return new ResponseEntity(allMovies,HttpStatus.CREATED);
    }
    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("director") String director){
        String response= movieService.deleteDirectorByName(director);
        return new ResponseEntity(response,HttpStatus.CREATED);
    }
    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        String response= movieService.deleteAllDirectors();
        return new ResponseEntity(response,HttpStatus.CREATED);
    }






}
