package com.tom.selling.imagelink.control;

import com.tom.selling.exception.ItemNotFoundException;
import com.tom.selling.imagelink.entity.ImageLinkDbo;
import com.tom.selling.imagelink.entity.ImageLinkDto;
import com.tom.selling.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ImageLinkService implements DataService<ImageLinkDto> {

    @Autowired
    private ImageLinkRepository imageLinkRepository;

    @Override
    public List<ImageLinkDto> getAll() {
        return StreamSupport
                .stream(imageLinkRepository.findAll().spliterator(), false)
                .map(ImageLinkDto::of)
                .collect(Collectors.toList());
    }

    @Override
    public ImageLinkDto getById(Long id) {
        return ImageLinkDto.of(imageLinkRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id)));
    }

    @Override
    public void createNew(ImageLinkDto newItem) {
        imageLinkRepository.save(ImageLinkDbo.of(newItem));
    }

    @Override
    public void deleteById(Long id) {
        imageLinkRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        imageLinkRepository.deleteAll();
    }

    @Override
    public void update(ImageLinkDto updatedItem) {
        imageLinkRepository.save(ImageLinkDbo.of(updatedItem));
    }
}
