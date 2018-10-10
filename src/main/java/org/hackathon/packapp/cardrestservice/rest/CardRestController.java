package org.hackathon.packapp.cardrestservice.rest;

import java.util.Collection;

import org.hackathon.packapp.cardrestservice.model.Card;
import org.hackathon.packapp.cardrestservice.model.CardType;
import org.hackathon.packapp.cardrestservice.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cardrest")
public class CardRestController {
    private final CardService cardService;

    @Autowired
    public CardRestController(CardService cardService) {
        this.cardService = cardService;
    }
    
    @RequestMapping("/findcardtypes")
    public Collection<CardType> findCardTypes() throws DataAccessException {
        return cardService.findCardTypes();
    }


    @RequestMapping("/findcardbyid")
    public Card findCardById(@RequestParam(value="id") int id) throws DataAccessException {
        return cardService.findCardById(id);
    }

    @RequestMapping("/savecard")
    public void saveCard(@RequestParam(value="card") Card card) throws DataAccessException {
    	cardService.saveCard(card);
    }
}
