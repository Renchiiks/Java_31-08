package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String title;
    private SongList songs;

    public Album(String title) {
        this.title = title;
        songs = new SongList();

    }

    public void addSong(String name, int duration) {
        if (name.isEmpty() && duration < 0) {
            System.out.println("Error");
        } else {

            songs.add(new Song(name, duration));
       }
    }

    public boolean addSongToPlaylist(String title, LinkedList<Song> playlist) {

        if (songs.findSong(title) != null) {
            Song songToAdd = songs.findSong(title);

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

    private class SongList {
        private ArrayList<Song> songs = new ArrayList<>();

        public SongList() {
            this.songs = new ArrayList<>();
        }

        public void add(Song song) {
            if (!songs.contains(song)) {
                System.out.println("Song added to the album");
                songs.add(song);

            } else {
                System.out.println("Song is already in the album");
            }
        }

        private Song findSong(Song song) {
            for (Song songToAdd : songs) {
                if (song.getTitle().equals(songToAdd.getTitle())) {
                    return song;
                }
            }
            return null;
        }

        private Song findSong(String title) {
            for (Song song : songs) {
                if (song.getTitle().equals(title)) {
                    return song;
                }
            }
            return null;
        }
    }

    public String getTitle() {
        return title;
    }

    private boolean findSongInPlayList(Song songToAdd, LinkedList<Song> songsInPlaylist) {
        for (Song song : songsInPlaylist) {
            if (song.getTitle().equals(songToAdd.getTitle())) {
                return true;
            }
        }
        return false;
    }


}
