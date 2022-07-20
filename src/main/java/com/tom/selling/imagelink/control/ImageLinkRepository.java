package com.tom.selling.imagelink.control;

import com.tom.selling.imagelink.entity.ImageLinkDbo;
import org.springframework.data.repository.CrudRepository;

public interface ImageLinkRepository extends CrudRepository<ImageLinkDbo, Long> {
}
