package com.tom.selling.imagelink.control;

import com.tom.selling.imagelink.entity.ImageLinkDto;
import com.tom.selling.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageLinkService implements DataService<ImageLinkDto> {

    @Autowired
    private ImageLinkRepository imageLinkRepository;

    @Override
    public List<ImageLinkDto> getAll() {
        return null;
    }

    @Override
    public ImageLinkDto getById(Long id) {
        return null;
    }

    @Override
    public void createNew(ImageLinkDto newItem) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void update(ImageLinkDto updatedItem) {

    }
}
