package com.tom.selling.artpiece.control;

import com.tom.selling.artpiece.entity.ImageLinkDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImageLinkRepository extends JpaRepository<ImageLinkDbo, Long> {
}
