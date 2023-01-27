package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MovieRepository {

    HashMap<String , Movie> moviemap = new HashMap<>();
    HashMap<String,Director> directormap = new HashMap<>();
    HashMap<String, List<String>> directormoviemap=new HashMap<>();

    public void createMovie(Movie movie) {
        moviemap.put(movie.getName(),movie);
    }

    public void createDirector(Director director) {
        directormap.put(director.getName(),director);
    }

    public String createMovieDirector(String movie, String director) {
        List<String> movies = directormoviemap.getOrDefault(director,new ArrayList<>());
        if(movies.contains(movie)){
            return "Pair Already Exists";
        }
        movies.add(movie);
        directormoviemap.put(director,movies);
        return "Pair Added Successfully";
    }

    public Movie getMovieByName(String movie) {
        if (moviemap.containsKey(movie)) {
                return moviemap.get(movie);

        }
        return null;

    }

    public Director getDirectorByName(String director) {
        if(directormap.containsKey(director)){
            return directormap.get(director);
        }
        return null;
    }

    public List<String> getMoviesByDirectorName(String director) {
        List<String> movieslist = new ArrayList<>();
        if(directormoviemap.containsKey(director)){
            movieslist = directormoviemap.get(director);
        }
        return movieslist;
    }

    public List<String> findllMovies() {
        List<String> allmovies = new ArrayList<>();
        for(String movie:moviemap.keySet()){
            allmovies.add(movie);
        }
        return allmovies;
    }

    public String deleteDirectorByName(String director) {
        List<String> movie = new ArrayList<>();
        if(directormoviemap.containsKey(director)){
            movie = directormoviemap.get(director);
        }
        for(String m:movie){
            if(directormoviemap.containsKey(m)){
                moviemap.remove(m);
            }
        }
        directormoviemap.remove(director);
        if(directormoviemap.containsKey(director)){
            directormoviemap.remove(director);
        }
        return "Director and their movies removed";

    }

    public String deleteAllDirectors() {
        HashSet<String> movieset = new HashSet<>();
        for(String director:directormoviemap.keySet()){
            for(String movie:directormoviemap.get(director)){
                movieset.add(movie);
            }
        }
        for(String movie:movieset){
            if(moviemap.containsKey(movie)){
                moviemap.remove((movie));
            }
        }
        return "All director and movies deleted";

    }
}
