package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String title;
    private ArrayList<Song> songs = new ArrayList<>();

    public Album(String title) {
        this.title = title;

    }

    public String getTitle() {
        return title;
    }

    public void addSong(String name, int duration) {
        if (findSong(name) == null) {
            System.out.println("Song added to the album");
            songs.add(new Song(name, duration));

        } else {
            System.out.println("Song is already in the album");
        }
    }

    public boolean addSongToPlaylist(String title, LinkedList<Song> playlist) {

        if (findSong(title) != null) {
            Song songToAdd = findSong(title);

            if (!findSongInPlayList(songToAdd, playlist)) {

                playlist.add(songToAdd);
                System.out.println("Song added to the playlist");
                return true;

            } else {
                System.out.println("Song" + title + " already is on the playlist");
                return false;
            }

        }

        System.out.println("The song " + title + " is not in this album");
        return false;

    }

    private boolean findSongInPlayList(Song songToAdd, LinkedList<Song> songsInPlaylist) {
        for (Song song : songsInPlaylist) {
            if (song.getTitle().equals(songToAdd.getTitle())) {
                return true;
            }
        }
        return false;
    }

    private Song findSong(String name) {
        for (Song song : songs) {
            if (song.getTitle().equals(name)) {
                return song;
            }
        }
        return null;
    }
}
