package fr.lusuva.lusuvair.dtos.forum;

import java.util.List;

import fr.lusuva.lusuvair.dtos.section.SectionResponseDto;
import fr.lusuva.lusuvair.entities.Forum;

/**
 * Data Transfer Object (DTO) for transferring forum data between processes.
 * <p>
 * This DTO encapsulates forum details such as ID, name, and associated
 * sections. It is primarily used
 * for sending forum data from the server to the client in a structured format.
 */
public class ForumResponseDto {

    /**
     * Unique identifier for the forum.
     */
    private int id;

    /**
     * Name of the forum.
     */
    private String name;

    /**
     * List of sections associated with the forum.
     */
    private List<SectionResponseDto> sections;

    /**
     * Constructs a new {@code ForumResponseDto} object using details from a
     * {@link Forum}.
     *
     * @param forum the {@code Forum} object containing the forum's details
     */
    public ForumResponseDto(Forum forum) {
        this.id = forum.getId();
        this.name = forum.getName();
        this.sections = forum.getSections().stream().map(SectionResponseDto::new).toList();
    }

    /**
     * Retrieves the unique identifier of the forum.
     *
     * @return the forum's ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the forum.
     *
     * @param id the new forum ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the forum.
     *
     * @return the forum name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the forum.
     *
     * @param name the new forum name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the list of sections associated with the forum.
     *
     * @return the list of {@code SectionResponseDto} objects
     */
    public List<SectionResponseDto> getSections() {
        return sections;
    }

    /**
     * Sets the list of sections associated with the forum.
     *
     * @param sections the new list of {@code SectionResponseDto} objects
     */
    public void setSections(List<SectionResponseDto> sections) {
        this.sections = sections;
    }
}
