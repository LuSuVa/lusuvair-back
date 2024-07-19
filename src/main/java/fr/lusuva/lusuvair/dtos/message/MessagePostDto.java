package fr.lusuva.lusuvair.dtos.message;

import jakarta.validation.constraints.NotNull;

/**
 * Message Post Dto expected from front
 */
public class MessagePostDto {

    /**
     * Section id
     */
    @NotNull
    private int sectionId;

    /**
     * Message's content
     */
    @NotNull
    private String content;

    /**
     * Empty constructor
     */
    public MessagePostDto() {
        super();
    }

    /**
     * Full constructor
     * 
     * @param sectionId int
     * @param content   String
     */
    public MessagePostDto(int sectionId, String content) {
        super();
        this.sectionId = sectionId;
        this.content = content;
    }

    /**
     * Get section's id
     * 
     * @return int
     */
    public int getSectionId() {
        return sectionId;
    }

    /**
     * Get content
     * 
     * @return String
     */
    public String getContent() {
        return content;
    }

    /**
     * Set Section's id
     * 
     * @param sectionId
     */
    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    /**
     * Set content
     * 
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
}
