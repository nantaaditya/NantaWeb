package com.nanta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nanta.entity.Picture;

@Repository
public interface PictureRepository extends JpaRepository<Picture, String> {
  List<Picture> findByStatusTrue() throws Exception;
}
