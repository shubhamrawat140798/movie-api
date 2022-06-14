package com.movie.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

/**
 * model for Movie entity.
 */
@Entity
public class Movie {
    @Id @GeneratedValue
    private @Getter int id;
    @NotEmpty(message = "Title cannot be empty")
    private @Getter @Setter String title;
    @NotEmpty(message = "Director cannot be empty")
    private @Getter @Setter String[] director;
    @NotEmpty(message = "Genre cannot be empty")
    private @Getter @Setter String[] genre;
    @NotEmpty(message = "Actor cannot be empty")
    private @Getter @Setter String[] actor;
    @NotEmpty(message = "Description cannot be empty")
    private @Getter @Setter String description;
    @NotEmpty(message = "Release date cannot be empty")
    private @Getter @Setter String releaseDate;


}
