/*
Chase Stevens
UNIVERSITY OF PITTSBURGH AT BRADFORD
CIST 1450 - FALL 2020
HOMEWORK 3
DO NOT MODIFY OR SUBMIT THIS FILE.
 */

import java.util.Hashtable;
import java.util.Scanner;
import java.io.*;
import java.nio.file.*;

public class Library {
    //attributes
    private String ownerName;
    private SongCollection home;
    private Hashtable<String, Playlist> playlists;

    //constructor
    public Library(String ownerName){
        this.ownerName = ownerName;
        this.home = new SongCollection("home");
        this.playlists = new Hashtable<String, Playlist>();
    }

    //getters
    public String getOwnerName() {
        return ownerName;
    }
    public SongCollection getHome() {
        return home;
    }
    public Hashtable<String, Playlist> getPlaylist() {
        return playlists;
    }

    //methods
    //attemts to read the demo_songs file and add the songs that are inside to the home directory
    public void uploadDemoSongs(){
        InputStream input = null;
        Path file = Paths.get("./demo_songs.txt");

        try {
            input = Files.newInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String checkLines = null;
            while((checkLines = reader.readLine()) != null) {
                String songDetails[] = checkLines.split(",");
                Song newSong = new Song(songDetails[0], songDetails[1], songDetails[2]);
                home.addSong(newSong);

           }
            input.close();
            System.out.println("Demo songs were added to library");
        }
        catch(Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    //Prompts user to create a new playlist
    public Playlist createPlaylist(Scanner inputDevice){
        System.out.print("What would you like to name the playlist? ");
        String tempName = inputDevice.next();
        System.out.print("What is the description of the playlist? ");
        String tempDescription = inputDevice.next();
        Playlist newPlaylist = new Playlist(tempName, tempDescription);
        System.out.println("Let's add a song to " + tempName + " playlist! ");

        //adds songs to the playlist even if the song does not already exist in Home
        char addAnother;
        do{
            //variables to hold data before they can be put into the playlist then cleans them for the next song
            String tempTitle;
            String tempArtist;
            String tempGenre;

            System.out.print("Enter song title: ");
            tempTitle = inputDevice.next();
            System.out.print("Enter artist name: ");
            tempArtist = inputDevice.next();
            System.out.print("Enter genre: ");
            tempGenre = inputDevice.next();

            Song newSong = new Song(tempTitle, tempArtist, tempGenre);
            newPlaylist.addSong(newSong);

            System.out.print("Would you like to add another song to " + tempName + " playlist? (y/n): ");
            addAnother = inputDevice.next().charAt(0);
        }while(Character.toLowerCase(addAnother) == 'y');

        return newPlaylist;
    }

    //creates a new playlist
    public void addPlaylist(Playlist playlist){
        this.playlists.put(playlist.getName(), playlist);

        playlist.getSongs().forEach((title, song) -> {
            this.home.addSong((Song) song);
        });
    }

    public void printLibrary(){
        System.out.println("LIBRARY OWNER: " + ownerName);
        System.out.println("SONGS IN LIBRARY: ");
        home.printSongs();

        playlists.forEach((name, playlist) -> {
            System.out.println("---------");
            System.out.println("PLAYLIST NAME: " + name);
            System.out.println("PLAYLIST DESCRIPTION: " + playlist.getDescription());
            playlist.printSongs();
        });
    }
}
