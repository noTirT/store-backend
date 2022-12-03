package com.tom.selling.artpiece.control;

import com.tom.selling.artpiece.entity.ArtPieceDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ArtRepository extends JpaRepository<ArtPieceDbo, Long> {
}
