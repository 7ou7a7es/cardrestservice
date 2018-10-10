
package org.hackathon.packapp.cardrestservice.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hackathon.packapp.cardrestservice.model.Card;
import org.hackathon.packapp.cardrestservice.model.CardType;
import org.hackathon.packapp.cardrestservice.repository.CardRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA implementation of the {@link CardRepository} interface.
 *
 * @author Wavestone
 */
@Repository
public class JpaCardRepositoryImpl implements CardRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public List<CardType> findCardTypes() {
        return this.em.createQuery("SELECT ptype FROM CardType ptype ORDER BY ptype.name").getResultList();
    }

    @Override
    public Card findById(int id) {
        return this.em.find(Card.class, id);
    }

    @Override
    public void save(Card card) {
        if (card.getId() == null) {
            this.em.persist(card);
        } else {
            this.em.merge(card);
        }
    }

}
