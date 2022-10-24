package com.song.service;

import com.song.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISongService {
    Page<Song>findAll(Pageable pageable);
    void save(Song song);
    Song findById(int id);
    Page<Song> findByNameContaining(Pageable pageable, String title);
}
