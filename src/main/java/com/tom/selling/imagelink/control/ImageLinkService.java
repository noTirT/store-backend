package com.tom.selling.imagelink.control;

import com.tom.selling.exception.ItemNotFoundException;
import com.tom.selling.imagelink.entity.ImageLinkDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ImageLinkService {

    @Autowired
    private ImageLinkRepository imageLinkRepository;

    public List<ImageLinkDto> getAll() {
        return StreamSupport
                .stream(imageLinkRepository.findAll().spliterator(), false)
                .map(ImageLinkDto::of)
                .collect(Collectors.toList());
    }

    public ImageLinkDto getById(Long id) {
        return ImageLinkDto.of(imageLinkRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id)));
    }

    public void deleteById(Long id) {
        imageLinkRepository.deleteById(id);
    }
}
