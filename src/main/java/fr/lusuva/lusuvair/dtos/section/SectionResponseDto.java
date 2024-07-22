package fr.lusuva.lusuvair.dtos.section;

import java.time.LocalDateTime;
import java.util.List;

import fr.lusuva.lusuvair.dtos.message.MessageResponseDto;
import fr.lusuva.lusuvair.dtos.user.UserResponseDto;
import fr.lusuva.lusuvair.entities.Section;

/**
 * Data Transfer Object (DTO) for transferring section data between processes.
 * <p>
 * This DTO encapsulates section details such as ID, title, content, creation or
 * modification date,
 * associated messages, and user details. It is primarily used for sending
 * section data from the server
 * to the client in a structured format.
 */
public class SectionResponseDto {

    /**
     * Unique identifier for the section.
     */
    private int id;

    /**
     * Title of the section.
     */
    private String title;

    /**
     * Content of the section.
     */
    private String content;

    /**
     * Date and time when the section was posted or last modified.
     */
    private LocalDateTime date;

    /**
     * List of messages associated with the section.
     */
    private List<MessageResponseDto> messages;

    /**
     * User who posted the section.
     */
    private UserResponseDto user;

    /**
     * Constructs a new {@code SectionResponseDto} object using details from a
     * {@link Section}.
     *
     * @param section the {@code Section} object containing the section's details
     */
    public SectionResponseDto(Section section) {
        this.id = section.getId();
        this.title = section.getName();
        this.content = section.getDescription();
        this.date = section.getDate();
        this.user = new UserResponseDto(section.getUser());
        this.messages = section.getMessages().stream().map(MessageResponseDto::new).toList();
    }

    /**
     * Retrieves the content of the section.
     *
     * @return the section content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the section.
     *
     * @param content the new section content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Retrieves the date and time when the section was posted or last modified.
     *
     * @return the {@code LocalDateTime} representing the date and time of the
     *         section
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Sets the date and time when the section was posted or last modified.
     *
     * @param date the new date and time for the section
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Retrieves the unique identifier of the section.
     *
     * @return the section's ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the section.
     *
     * @param id the new section ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the list of messages associated with the section.
     *
     * @return the list of {@code MessageResponseDto} objects
     */
    public List<MessageResponseDto> getMessages() {
        return messages;
    }

    /**
     * Sets the list of messages associated with the section.
     *
     * @param messages the new list of {@code MessageResponseDto} objects
     */
    public void setMessages(List<MessageResponseDto> messages) {
        this.messages = messages;
    }

    /**
     * Retrieves the title of the section.
     *
     * @return the section title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the section.
     *
     * @param title the new section title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retrieves the details of the user who posted the section.
     *
     * @return the {@code UserResponseDto} associated with the section
     */
    public UserResponseDto getUser() {
        return user;
    }

    /**
     * Sets the details of the user who posted the section.
     *
     * @param user the {@code UserResponseDto} object representing the user
     */
    public void setUser(UserResponseDto user) {
        this.user = user;
    }
}
