package fr.lusuva.lusuvair.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lusuva.lusuvair.dtos.message.MessagePostDto;
import fr.lusuva.lusuvair.dtos.message.MessagePutDto;
import fr.lusuva.lusuvair.entities.Message;
import fr.lusuva.lusuvair.entities.Section;
import fr.lusuva.lusuvair.entities.UserAccount;
import fr.lusuva.lusuvair.repositories.MessageRepository;
import fr.lusuva.lusuvair.repositories.SectionRepository;

/**
 * Message Service
 */
@Service
public class MessageService {

    /**
     * Message Repository
     */
    @Autowired
    private MessageRepository messageRepository;

    /**
     * Section Repository
     */
    @Autowired
    private SectionRepository sectionRepository;

    /**
     * Create a Message and return it
     * 
     * @param messagePostDto Dto
     * @param userAccount    Authenticated User
     * @return Message newly savec
     * @throws IllegalArgumentException if Section doesn't exist
     */
    public Message create(MessagePostDto messagePostDto, UserAccount userAccount) throws IllegalArgumentException {
        Section section = sectionRepository.findById(messagePostDto.getSectionId()).orElse(null);

        if (section == null) {
            throw new NoSuchElementException("Section doesn't exist");
        }

        Message message = new Message();

        message.setContent(messagePostDto.getContent());
        message.setUser(userAccount);
        message.setDate(LocalDateTime.now());
        message.setLike(0);
        message.setDislike(0);

        return messageRepository.save(message);
    }

    /**
     * Get message by id
     * 
     * @param id int
     * @return Message
     * @throws NoSuchElementException if Message is not find
     */
    public Message getById(int id) throws NoSuchElementException {
        Message message = messageRepository.findById(id).orElse(null);

        if (message == null) {
            throw new NoSuchElementException("Could not find message");
        }

        return message;
    }

    /**
     * Get all
     * 
     * @return List of Message
     */
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    /**
     * Update by id
     * 
     * @param id            int
     * @param messagePutDto Dto
     * @return Message updated
     */
    public Message updateById(int id, MessagePutDto messagePutDto) {
        Message message = getById(id);

        message.setContent(messagePutDto.getContent());

        messageRepository.save(message);

        return message;
    }

    public void deleteById(int id) {
        messageRepository.delete(getById(id));
    }
}
