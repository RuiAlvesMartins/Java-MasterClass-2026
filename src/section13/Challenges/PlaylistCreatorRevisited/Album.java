package section13.Challenges.PlaylistCreatorRevisited;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    
    public static class SongList {

        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<>();
        }

        private boolean add(Song song) {
            //  true if added successfully;
            if (findSong(song.getTitle()) == null) {
                //  no duplicate found, song will be added;
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
            System.out.println("The song " + title + " is not in this album");
            return null;
        }

        private Song findSong(int track) {
            //  null if song not found;
            try {
                return songs.get(track - 1);
            } catch (IndexOutOfBoundsException iobe) {
                //  track not found
                System.out.println("This album does not have a track " + (track + 1));
                return null;
            }
        }

    }

    private String name;
    private String artist;
    // private ArrayList<Song> songs;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration) {
        Song songToBeAdded = new Song(title, duration);
        return songs.add(songToBeAdded);       
    }

    // private Song findSong(String title) {
    //     //  null if song not found;
    //     for (Song song : songs) {
            
    //         if (song.getTitle().equals(title)) {
    //             //  song found;
    //             return song;
    //         }

    //     }

    //     return null;

    // }

    public boolean addToPlayList(int track, LinkedList<Song> playList) {
        //  true if song was found and added to playlist
        Song songToAdd = songs.findSong(track - 1);
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

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        //  true if song was found and added to playlist
        Song songToAdd = songs.findSong(title);

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
