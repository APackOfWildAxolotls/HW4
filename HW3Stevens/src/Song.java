/*
Chase Stevens
UNIVERSITY OF PITTSBURGH AT BRADFORD
CIST 1450 - FALL 2020
HOMEWORK 3
DO NOT MODIFY OR SUBMIT THIS FILE.
 */

public class Song {
    //Attributes
    private String title;
    private String artist;
    private String genre;

    //constructor
    public Song(String title, String artist, String genre){
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    //getters
    public String getTitle() {
        return this.title;
    }
    public String getArtist() {
        return this.artist;
    }
    public String getGenre() {
        return this.genre;
    }

    //setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
}
