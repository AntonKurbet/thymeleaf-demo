package com.example.thdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;

    public Optional<Document> getById(Long id) {
        return documentRepository.findById(id);
    }

    public Document add(Document product) {
        return documentRepository.save(product);
    }

    public void delete(Long id) {
        documentRepository.deleteById(id);
    }

    public List<Document> getAll() {
        return documentRepository.findAll();
    }
}