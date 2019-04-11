package ru.sbrf.sandbox.sberchat.domain;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;

public class SberchatServiceImpl implements SberchatService {

    @Autowired
    MessageRepository messageRepository;

    @Override
    public Collection<Message> getMessages() {
        //return StreamSupport.stream(messageRepository.findAll().spliterator(), false).collect(toList());
        ArrayList<Message> result = new ArrayList<>();
        messageRepository.findAll().forEach(m -> result.add(m));
        return result;
    }

    @Override
    public void addMessage(Message message) {
        messageRepository.save(message);
    }
}