package com.example.springbootexercise3_06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SongRepository songRepository;

    @RequestMapping("/")
    public String index(Model model){

        Album album = new Album();

        album.setTitle("The Dark Side of The Moon");
        album.setBand("Pink Floyd");
        album.setYear(1973);
        album.setDescription("Rock");

        Song song = new Song();
        song.setTitle("Speak To Me");
        song.setLength("3:57");

        Set<Song> songs = new HashSet<Song>();
        songs.add(song);

        song = new Song();
        song.setTitle("Breathe In The Air");
        song.setLength("3:37");
        songs.add(song);

        song = new Song();
        song.setTitle("On The Run");
        song.setLength("3:31");
        songs.add(song);

        song = new Song();
        song.setTitle("Time");
        song.setLength("7:05");
        songs.add(song);

        song = new Song();
        song.setTitle("The Great Gig In The Sky");
        song.setLength("4:47");
        songs.add(song);

        song = new Song();
        song.setTitle("Money");
        song.setLength("6:23");
        songs.add(song);

        song = new Song();
        song.setTitle("Us And Them");
        song.setLength("7:48");
        songs.add(song);

        song = new Song();
        song.setTitle("Any Colour You Like");
        song.setLength("3:25");
        songs.add(song);

        song = new Song();
        song.setTitle("Brain Damage");
        song.setLength("3:50");
        songs.add(song);

        song = new Song();
        song.setTitle("Eclipse");
        song.setLength("2:06");
        songs.add(song);

        album.setSongs(songs);

        albumRepository.save(album);

        model.addAttribute("albums", albumRepository.findAll());
        return "index";
    }
}
