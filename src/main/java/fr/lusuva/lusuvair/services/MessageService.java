package fr.lusuva.lusuvair.services;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lusuva.lusuvair.dtos.message.MessagePostDto;
import fr.lusuva.lusuvair.entities.Message;
import fr.lusuva.lusuvair.entities.Section;
import fr.lusuva.lusuvair.entities.UserAccount;
import fr.lusuva.lusuvair.repositories.MessageRepository;
import fr.lusuva.lusuvair.repositories.SectionRepository;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private SectionRepository sectionRepository;

    public Message create(MessagePostDto messagePostDto, UserAccount userAccount) {
        Section section = sectionRepository.findById(messagePostDto.getSectionId()).orElse(null);

        if(section == null){
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
}
