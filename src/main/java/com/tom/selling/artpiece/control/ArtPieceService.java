package com.tom.selling.artpiece.control;

import com.tom.selling.artpiece.entity.ArtPieceDbo;
import com.tom.selling.artpiece.entity.ArtPieceDto;
import com.tom.selling.artpiece.entity.ArtPieceRequest;
import com.tom.selling.category.control.CategoryRepository;
import com.tom.selling.category.entity.CategoryDbo;
import com.tom.selling.exception.CategoryNotFoundException;
import com.tom.selling.exception.ItemNotFoundException;
import com.tom.selling.imagelink.control.ImageLinkRepository;
import com.tom.selling.imagelink.entity.ImageLinkDbo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ArtPieceService  {

    @Autowired
    private ArtRepository artRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ImageLinkRepository imageLinkRepository;

    public List<ArtPieceDto> getAll() {
        return StreamSupport
                .stream(artRepository.findAll().spliterator(), false)
                .map(ArtPieceDto::of)
                .collect(Collectors.toList());
    }

    public ArtPieceDto getById(Long id) {
        Optional<ArtPieceDbo> artPieceDboOptional = artRepository.findById(id);
        if (artPieceDboOptional.isPresent()) {
            return ArtPieceDto.of(artPieceDboOptional.get());
        }
        throw new ItemNotFoundException(id);
    }

    public void createNew(ArtPieceRequest request) {
        CategoryDbo itemCategory = categoryRepository.findById(request.getCategoryID())
                .orElseThrow(() -> new CategoryNotFoundException(request.getCategoryID()));

        ArtPieceDbo artPieceDbo = new ArtPieceDbo();
        artPieceDbo.setCategory(itemCategory);
        artPieceDbo.setDescription(request.getDescription());
        artPieceDbo.setName(request.getName());
        artPieceDbo.setPrice(request.getPrice());

        final ArtPieceDbo artPieceDboFinal = artRepository.save(artPieceDbo);

        request.getImageURLs()
                .forEach(URL ->
                        imageLinkRepository.save(new ImageLinkDbo(URL, artPieceDboFinal)));
    }

    public void deleteById(Long id) {
        artRepository.deleteById(id);
    }

    public void update(ArtPieceDto updatedItem) {
        artRepository.save(ArtPieceDbo.of(updatedItem));
    }
}
