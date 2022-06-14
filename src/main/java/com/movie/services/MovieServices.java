package com.movie.services;
import com.movie.model.Movie;
import com.movie.repository.MovieRepository;
import com.movie.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Services for Controller.
 */
@Service
public class MovieServices {
    @Autowired
    Validation validation;
    @Autowired
    MovieRepository movieRepository;
    /**
     * for add movies to the database.
     * @param movieReceived movie input.
     * @return status of operation [successfully added or not]
     */
    public String addMovie(final Movie movieReceived){
        String checkMovieReceived= validation
                .checkMovieFieldsNotEmpty(movieReceived);
        if (checkMovieReceived == ""){
            movieRepository.save(movieReceived);
            return "Movie saved";
        }
        return checkMovieReceived;
    }

    /**
     * to find all entries in the database.
     * @return List of Movies.
     */
    public List<Movie> findAll(){
        return movieRepository.findAll();
    }

    /**
     * to delete entry by id.
     * @param movieReceived input from user.
     * @return status of the query in string.
     */
    public String delete(final Movie movieReceived){
        if (movieRepository.existsById(movieReceived.getId())){
            movieRepository.delete(movieRepository
                    .getReferenceById(movieReceived.getId()));
            return "movie deleted";
        }
        return "movie does not exist";
    }

    /**
     * to  edit previous entry.
     * @param movieReceived input from user.
     * @return status of query in string.
     */
    public String editMovie(final Movie movieReceived){
        String error="";
        if (movieRepository.existsById(movieReceived.getId())){
            Movie editMovie = movieRepository
                    .getReferenceById(movieReceived.getId());
            if (movieReceived.getReleaseDate() != null){
                if (validation.dateValidator(movieReceived.getReleaseDate()) == ""){
                    editMovie.setReleaseDate(movieReceived.getReleaseDate());
                } else {
                    error +="Refer to this [format dd-mm-yyyy]";
                }
            }
            if (movieReceived.getGenre() != null){
                editMovie.setGenre(movieReceived.getGenre());
            }
            if (movieReceived.getActor() != null){
                editMovie.setActor(movieReceived.getActor());
            }
            if (movieReceived.getTitle() != null){
                editMovie.setTitle(movieReceived.getTitle());
            }
            if (movieReceived.getDirector() != null){
                editMovie.setDirector(movieReceived.getDirector());
            }
            if (movieReceived.getDescription() != null){
                editMovie.setDescription(movieReceived.getDescription());
            }
            if (error == ""){
                movieRepository.save(editMovie);
                return "movie is edited.";
            }
        }
        return error;
    }
}
