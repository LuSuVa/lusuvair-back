package fr.lusuva.lusuvair.dtos.section;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Section Post Dto expected from front
 */
public class SectionPostDto {
    /**
     * Title
     */
    @NotNull
    @Size(min = 4, max = 255)
    private String title;

    /**
     * Content
     */
    @NotNull
    @Size(min = 4, max = 1024)
    private String content;

    /**
     * Forum's id
     */
    @NotNull
    private int forumId;

    /**
     * Empty constructor
     */
    public SectionPostDto() {
        super();
    }

    /**
     * Full constructor
     * 
     * @param title   String
     * @param content String
     * @param forumId int
     */
    public SectionPostDto(String title, String content, int forumId) {
        super();
        this.title = title;
        this.content = content;
        this.forumId = forumId;
    }

    /**
     * Get title
     * 
     * @return String
     */
    public String getTitle() {
        return title;
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
     * Get forum's id
     * @return int
     */
    public int getForumId() {
        return forumId;
    }

    /**
     * Set title
     * 
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Set content
     * 
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Set forum's id
     * @param forumId
     */
    public void setForumId(int forumId) {
        this.forumId = forumId;
    }
}
