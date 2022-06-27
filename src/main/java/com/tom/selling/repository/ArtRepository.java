package com.tom.selling.repository;

import com.tom.selling.model.ArtPiece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ArtRepository extends CrudRepository<ArtPiece, Long> {


}
