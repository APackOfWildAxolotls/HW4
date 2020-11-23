/*
Chase Stevens
UNIVERSITY OF PITTSBURGH AT BRADFORD
CIST 1450 - FALL 2020
HOMEWORK 3
DO NOT MODIFY OR SUBMIT THIS FILE.
 */

import java.util.Hashtable;

public class SongCollection {
    //attributes
    private String name;
    private Hashtable<String, Song> songs;

    //constructor
    public SongCollection(String name){
        this.name = name;
        songs = new Hashtable<String, Song>();
    }

    //getters
    public String getName() {
        return name;
    }
    public Hashtable<String, Song> getSongs() {
        return songs;
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }

    //methods
    //when a new song ing created it is forced to get a title
    public void addSong(Song song){
        this.songs.put(song.getTitle(), song);
    }

    //this method lists all songs that are contained within the song hashtable
    public void printSongs(){
        songs.forEach((title, song) -> {
            System.out.println("---------");
            System.out.println("Title: " + title);
            System.out.println("Artist: " + song.getArtist());
            System.out.println("Genre: " + song.getGenre());
        });
    }

    //retrieves song title (required via instructions but never implemented)
    public Song lookUpSong(String title){
        return this.songs.get(title);
    }
}
