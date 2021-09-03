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

    @ModelAttribute("wrapper")
    public DocumentList getDocuments() {
        DocumentList data = new DocumentList();
        ArrayList<SelectableDocument> arr = new ArrayList<>();
        documentService.getAll().stream().forEach(e -> arr.add(toSelectableDocument(e)));
        data.setDocumentList(arr);
        return data;
    }

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/process")
    public String processDocuments(@ModelAttribute("wrapper") DocumentList data) {
        for (SelectableDocument d : data.getDocumentList()) System.out.println(d.isSelected());
        return "index.html";
    }

    @GetMapping("/all")
    public String getAllDocuments() {
        return "index.html";
    }

    private SelectableDocument toSelectableDocument(Document document) {
        return new SelectableDocument(document);
    }
}
