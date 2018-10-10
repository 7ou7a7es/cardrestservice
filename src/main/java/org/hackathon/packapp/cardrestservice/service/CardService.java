package org.hackathon.packapp.cardrestservice.service;

import java.util.Collection;

import org.hackathon.packapp.cardrestservice.model.Card;
import org.hackathon.packapp.cardrestservice.model.CardType;
import org.springframework.dao.DataAccessException;

public interface CardService {

    Collection<CardType> findCardTypes() throws DataAccessException;
    
    Card findCardById(int id) throws DataAccessException;

    void saveCard(Card card) throws DataAccessException;
    
}
