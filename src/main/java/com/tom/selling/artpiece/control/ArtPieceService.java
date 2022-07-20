package com.tom.selling.artpiece.control;

import com.tom.selling.exception.ItemNotFoundException;
import com.tom.selling.artpiece.entity.ArtPieceDbo;
import com.tom.selling.artpiece.entity.ArtPieceDto;
import com.tom.selling.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ArtPieceService implements DataService<ArtPieceDto> {

    @Autowired
    private ArtRepository repository;

    @Override
    public List<ArtPieceDto> getAll() {
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .map(ArtPieceDto::of)
                .collect(Collectors.toList());
    }

    @Override
    public ArtPieceDto getById(Long id) {
        Optional<ArtPieceDbo> artPieceDboOptional = repository.findById(id);
        if (artPieceDboOptional.isPresent()) {
            return ArtPieceDto.of(artPieceDboOptional.get());
        }
        throw new ItemNotFoundException(id);
    }

    @Override
    public void createNew(ArtPieceDto newItem) {
        repository.save(ArtPieceDbo.of(newItem));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void update(ArtPieceDto updatedItem) {
        repository.save(ArtPieceDbo.of(updatedItem));
    }
}
