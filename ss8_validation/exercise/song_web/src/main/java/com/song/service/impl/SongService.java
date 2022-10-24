package com.song.service.impl;

import com.song.model.Song;
import com.song.repository.ISongRepository;
import com.song.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public Page<Song> findAll(Pageable pageable) {
        return songRepository.findAll(pageable);
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id);
    }

    @Override
    public Page<Song> findByNameContaining(Pageable pageable, String title) {
        return songRepository.findByNameContaining(pageable, title);
    }
}
