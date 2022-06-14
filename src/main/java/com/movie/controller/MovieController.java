package com.movie.controller;

import com.movie.model.Movie;
import com.movie.services.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for movies.
 */
@RestController
@RequestMapping(path = "/v1.0/movie")
public class MovieController {
    @Autowired
    MovieServices movieServices;

    /**
     * POST Method.
     * @param movieReceived input from client.
     * @return status of request.
     */
    @PostMapping(path = "/add")
    public @ResponseBody String addMovie(@RequestBody Movie movieReceived){
        return movieServices.addMovie(movieReceived);
    }

    /**
     * GET Method.
     * @return return list of Movie object.
     */
    @GetMapping(path = "/all")
    public @ResponseBody List<Movie> findAll(){
        return  movieServices.findAll();
    }

    /**
     * DELETE Method.
     * @param movieReceived movie id as input.
     * @return string for status of query.
     */
    @DeleteMapping(path = "/delete")
    public @ResponseBody String deleteMovie(@RequestBody Movie movieReceived){
        return  movieServices.delete(movieReceived);
    }

    /**
     * PUT Method.
     * @param movieReceived movie input for edit.
     * @return String for status of the query.
     */
    @PutMapping(path = "/edit")
    public @ResponseBody String editMovie(@RequestBody Movie movieReceived){
        return movieServices.editMovie(movieReceived);
    }
}
