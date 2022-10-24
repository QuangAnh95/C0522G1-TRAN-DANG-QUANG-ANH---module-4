package com.song.repository;

import com.song.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongRepository extends JpaRepository<Song,Integer> {
    Page<Song> findAll(Pageable pageable);
    Song findById(int id);
    Page<Song> findByNameContaining(Pageable pageable, String title);
}
