package com.example.thdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;

    @ModelAttribute("documents")
    public List<SelectableDocument> getdocuments() {
        return documentService.getAll().stream().map(this::toSelectableDocument).collect(Collectors.toList());
    }

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/process")
    public String processDocuments(@ModelAttribute(value="documents") List<SelectableDocument> data) {
        System.out.println(data);
        return "index.html";
    }

    @GetMapping("/all")
    public String getAllDocuments(Model model) {
        List<SelectableDocument> data = documentService.getAll().stream().map(this::toSelectableDocument).collect(Collectors.toList());
        model.addAttribute("documents", data);
        return "index.html";
    }

    private SelectableDocument toSelectableDocument(Document document) {
        return new SelectableDocument(document);
    }
//
//    @GetMapping
//    public List<Document> getAll() {
//        return documentService.getAll();
//    }
//
//    @GetMapping("/{id}")
//    public Document getById(@PathVariable Long id) {
//        return documentService.getById(id).orElse(new Document("no-doc", BigDecimal.ZERO));
//    }
//
//    @PostMapping
//    public Document add(@RequestBody Document document) {
//        return documentService.add(document);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        documentService.delete(id);
//    }
}
