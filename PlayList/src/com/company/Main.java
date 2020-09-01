package com.company;

import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList<Song> playList = new LinkedList<>();

        Album album = new Album("Their Greatest Hits (1971-1975)");
        album.addSong("Take it easy", 209);
        album.addSong("Witchy Women", 250);
        album.addSong("Lyin' Eyes", 381);
        album.addSong("Already Gone", 253);
        album.addSong("Desperado", 213);
        album.addSong("One of These Nights", 291);
        album.addSong("Tequila Sunrise", 172);
        album.addSong("Take It to the Limit", 288);
        album.addSong("Peaceful Easy Feeling", 256);
        album.addSong("Best of My Love", 275);

        albums.add(album);

        album = new Album("Thriller");
        album.addSong("Wanna Be Startin' Somethin", 362);
        album.addSong("Baby Be Mine", 260);
        album.addSong("The Girl Is Mine", 221);
        album.addSong("Thriller", 357);
        album.addSong("Beat It", 258);
        album.addSong("Billie Jean", 294);
        album.addSong("Human Nature", 247);
        album.addSong("P.Y.T. (Pretty Young Thing)", 238);
        album.addSong("The Lady in My Life", 299);

        albums.add(album);

        albums.get(0).addSongToPlaylist("Take it easy", playList);
        albums.get(0).addSongToPlaylist("Already Gone", playList);
        albums.get(0).addSongToPlaylist("Tequila Sunrise", playList);
        albums.get(0).addSongToPlaylist("Take it easy", playList);
        albums.get(1).addSongToPlaylist("The Girl Is Mine", playList);
        albums.get(1).addSongToPlaylist("Billie Jean", playList);
        albums.get(1).addSongToPlaylist("The Girl Is Mine", playList);
        albums.get(1).addSongToPlaylist("Take it easy", playList);


        play(playList);


    }

    private static void play(LinkedList<Song> playlist) {
        Scanner scanner = new Scanner(System.in);
        ListIterator<Song> songIterator = playlist.listIterator();
        optionMenu();
        boolean quit = false;
        boolean forward = true;

        while (!quit) {
            System.out.println("Choose option");
            int option = scanner.nextInt();
            switch (option) {
                case 0:
                    optionMenu();
                    break;
                case 1:
                    if (!forward) {
                        if (songIterator.hasNext()) {
                            songIterator.next();
                        }
                        forward = true;
                    }
                    if (songIterator.hasNext()) {
                        System.out.println("Now playing " + songIterator.next().toString());
                    } else {
                        System.out.println("Reached end of playlist");
                    }
                    break;
                case 2:
                    if (forward) {
                        if (songIterator.hasPrevious()) {
                            songIterator.previous();
                        }
                        forward = false;
                    }
                    if (songIterator.hasPrevious()) {
                        System.out.println("Now playing " + songIterator.previous().toString());
                    } else {
                        System.out.println("Reached start of the playlist");
                    }
                    break;
                case 3:
                    if (forward) {
                        if (songIterator.hasPrevious()) {
                            System.out.println("Now playing " + songIterator.previous().toString());
                        }
                        forward = false;

                    } else {
                        if (songIterator.hasNext()) {
                            System.out.println("Now playing " + songIterator.next().toString());
                        }
                        forward = true;

                    }
                    break;
                case 4:
                    printSongsInThePlaylist(playlist);
                    break;
                case 5:
                    if (playlist.size() <= 0) {
                        System.out.println("there are no songs in the playlist");
                        break;
                    }
                    songIterator.remove();
                    if (songIterator.hasNext()) {
                        System.out.println("Now playing " + songIterator.next().toString());
                    } else if (songIterator.hasPrevious()) {
                        System.out.println("Now playing " + songIterator.previous().toString());
                    }
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    private static void printSongsInThePlaylist(LinkedList<Song> playlist) {
        for (Song song : playlist) {
            System.out.println(song.getTitle());
        }
    }

    private static void optionMenu() {

        System.out.println("0 - Print options\n" +
                "1 - Go to next song\n" +
                "2 - Go to previous song\n" +
                "3 - Replay the song\n" +
                "4 - Print songs on the playlist\n" +
                "5 - Remove song\n" +
                "6 - Quit");

    }
}
