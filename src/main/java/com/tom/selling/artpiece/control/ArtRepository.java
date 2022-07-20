package com.tom.selling.artpiece.control;

import com.tom.selling.artpiece.entity.ArtPieceDbo;
import org.springframework.data.repository.CrudRepository;

public interface ArtRepository extends CrudRepository<ArtPieceDbo, Long> {


}
