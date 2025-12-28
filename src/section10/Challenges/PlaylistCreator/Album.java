package section10.Challenges.PlaylistCreator;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        //  true if added successfully;
        if (findSong(title) == null) {
            //  no duplicate found, song may be added;
            Song song = new Song(title, duration);
            songs.add(song);
            return true;
        }
        return false;        
    }

    private Song findSong(String title) {
        //  null if song not found;
        for (Song song : songs) {
            
            if (song.getTitle().equals(title)) {
                //  song found;
                return song;
            }

        }

        return null;

    }

    public boolean addToPlayList(int track, LinkedList<Song> playList) {
        //  true if song was found and added to playlist
        Song songToAdd;
        try {
            songToAdd = songs.get(track - 1);
        } catch (IndexOutOfBoundsException e) {
            // song not found;
            return false;
        }
        for (Song song : playList) {
            
            if (song.equals(songToAdd)) {
                //  song already on playlist!
                return false;
            }

        }

        playList.addFirst(songToAdd);
        return true;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        //  true if song was found and added to playlist
        Song songToAdd = findSong(title);

        if (songToAdd == null) {
            //  song not found in album!
            return false;
        }

        for (Song song : playList) {
            
            if (song.equals(songToAdd)) {
                //  song already on playlist!
                return false;
            }

        }

        playList.addFirst(songToAdd);
        return true;

    }

}
