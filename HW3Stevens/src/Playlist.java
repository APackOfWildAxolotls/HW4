/*
Chase Stevens
UNIVERSITY OF PITTSBURGH AT BRADFORD
CIST 1450 - FALL 2020
HOMEWORK 3
DO NOT MODIFY OR SUBMIT THIS FILE.
 */

public class Playlist extends SongCollection{
    //attributes
    private String description;

    //constructor
    public Playlist(String name, String description){
        super(name);
        this.description = description;
    }

    //getter
    public String getDescription() {
        return description;
    }

    //setter
    public void setDescription(String description) {
        this.description = description;
    }
}
