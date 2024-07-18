package fr.lusuva.lusuvair.dtos.forum;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Forum Dto expected from front when POST
 */
public class ForumPostDto {

    /**
     * Name
     */
    @NotNull
    @Size(min = 3, max = 255)
    private String name;

    /**
     * Empty constructor
     */
    public ForumPostDto() {
        super();
    }

    /**
     * Name constructor
     * 
     * @param name
     */
    public ForumPostDto(String name) {
        super();
        this.name = name;
    }

    /**
     * Get name
     * 
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Set name
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
