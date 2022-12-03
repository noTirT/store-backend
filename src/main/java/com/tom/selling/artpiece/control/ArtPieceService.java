package com.tom.selling.artpiece.control;

import com.tom.selling.artpiece.entity.ArtPieceDbo;
import com.tom.selling.artpiece.entity.ArtPieceDto;
import com.tom.selling.artpiece.entity.ArtPieceRequest;
import com.tom.selling.category.control.CategoryRepository;
import com.tom.selling.category.entity.CategoryDbo;
import com.tom.selling.exception.ItemNotFoundException;
import com.tom.selling.artpiece.entity.ImageLinkDbo;
import com.tom.selling.exception.RequestValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ArtPieceService {

    private final ArtRepository artRepository;
    private final CategoryRepository categoryRepository;
    private final ImageLinkRepository imageLinkRepository;

    public List<ArtPieceDto> getAll() {
        return artRepository.findAll().stream()
                .map(ArtPieceDto::of)
                .collect(Collectors.toList());
    }

    public ArtPieceDto getById(Long id) {
        return ArtPieceDto.of(artRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id)));
    }

    public void createNew(ArtPieceRequest request) {
        RequestValidator.validateArtPiece(request);

        var itemCategory = categoryRepository.findByCategoryName(request.getCategoryName())
                .orElseGet(() -> categoryRepository.save(new CategoryDbo(request.getCategoryName())));

        var artPieceDbo = new ArtPieceDbo();
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
