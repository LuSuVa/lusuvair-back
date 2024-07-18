package fr.lusuva.lusuvair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lusuva.lusuvair.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    
}
