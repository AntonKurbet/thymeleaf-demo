package com.example.thdemo;

import lombok.Getter;
import lombok.Setter;

public class SelectableDocument extends Document{
    @Getter
    @Setter
    private boolean selected;

    public SelectableDocument(Document document) {
        this.selected = false;
        this.setId(document.getId());
        this.setTitle(document.getTitle());
        this.setAmount(document.getAmount());
    }
}
