package ru.sbrf.sandbox.sberchat.domain;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Transactional
public class JpaSberchatService implements SberchatService {

    @PersistenceContext(unitName = "SberchatPU")
    private EntityManager em;

    public Collection<Message> getMessages() {
        Query q = em.createQuery("SELECT m FROM Message m");
        List result = q.getResultList();
        return result;
    }

    public void addMessage(Message message) {
        em.persist(message);
    }

}
