package com.movie.model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for model Movie.
 */
class MovieTest {
    private Movie movie;
    /**
     * object creation for testing.
     */
    @BeforeEach
    void setup(){
        movie = new Movie();
    }
    /**
     * test for title
     */
    @Test
    void getTitle() {
        movie.setTitle("Hero");
        assertEquals("Hero",movie.getTitle());
    }
    /**
     * test for director.
     */
    @Test
    void getDirector() {
        movie.setDirector(new String[]{"Janet"});
        assertArrayEquals(new String[]{"Janet"},movie.getDirector());
    }
    /**
     * test for genre.
     */
    @Test
    void getGenre() {
        movie.setGenre(new String[]{"Adventure","Comedy"});
        assertArrayEquals(new String[]{"Adventure","Comedy"},movie.getGenre());
    }
    /**
     * test for actor.
     */
    @Test
    void getActor() {
        movie.setActor(new String[]{"Alex","Jimmy"});
        assertArrayEquals(new String[]{"Alex","Jimmy"},movie.getActor());
    }
    /**
     * test for description.
     */
    @Test
    void getDescription() {
        movie.setDescription("It is adventurous life Max(Alex)");
        assertEquals("It is adventurous life Max(Alex)",movie.getDescription());
    }
    /**
     * test for releaseDate.
     */
    @Test
    void getReleaseDate(){
        movie.setReleaseDate("2020-12-1");
        assertEquals("2020-12-1",movie.getReleaseDate());
    }
}
