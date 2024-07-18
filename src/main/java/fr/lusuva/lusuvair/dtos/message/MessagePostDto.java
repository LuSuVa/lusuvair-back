package fr.lusuva.lusuvair.dtos.message;

import jakarta.validation.constraints.NotNull;

public class MessagePostDto {

    @NotNull
    private int sectionId;
    
    @NotNull
    private String content;

    public MessagePostDto() {
        super();
    }

    public MessagePostDto(int sectionId, String content) {
        super();
        this.sectionId = sectionId;
        this.content = content;
    }

    public int getSectionId() {
        return sectionId;
    }

    public String getContent() {
        return content;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
