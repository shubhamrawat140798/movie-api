package com.movie.validation;

import com.movie.model.Movie;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * validation for service.
 */
@Component
public class Validation {
    public String checkMovieFieldsNotEmpty(Movie movieReceived){
        String error = "";
        if (movieReceived.getTitle() == null){
            error += "Title cannot be empty.\n";
        }
        if (movieReceived.getDirector() == null){
            error += "Director cannot be empty.\n";
        }
        if (movieReceived.getDescription() == null){
            error += "Description cannot be empty.\n";
        }
        if (movieReceived.getActor() == null){
            error += "Actor cannot be empty.\n";
        }
        if (movieReceived.getGenre() == null){
            error += "Genre cannot be empty.\n";
        }
        if (movieReceived.getReleaseDate() != null){
            String regex = "^(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])-[0-9]{4}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(movieReceived.getReleaseDate());
            if (!matcher.matches()){
                error += "Refer to this [format dd-mm-yyyy]";
            }
        }
        else {
            error += "Release date cannot be empty [format dd-mm-yyyy]";
        }

        return error;
    }
    public String dateValidator(String date){
        if (date != null){
            String regex = "^(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])-[0-9]{4}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(date);
            if (!matcher.matches()){
                return "Refer to this [format dd-mm-yyyy]";
            }
            return "";
        }
        return "next";
    }
}
