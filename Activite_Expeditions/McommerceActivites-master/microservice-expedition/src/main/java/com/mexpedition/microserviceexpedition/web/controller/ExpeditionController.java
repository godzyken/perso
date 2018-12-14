package com.mexpedition.microserviceexpedition.web.controller;

import com.mexpedition.microserviceexpedition.dao.ExpeditionDao;
import com.mexpedition.microserviceexpedition.model.Expedition;
import com.mexpedition.microserviceexpedition.web.controller.exceptions.ExpeditionNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static com.mexpedition.microserviceexpedition.dao.ExpeditionDao.*;

@RestController
public class ExpeditionController implements HealthIndicator {

    @Autowired
    ExpeditionDao expeditionDao;

    Logger log = LoggerFactory.getLogger(this.getClass());

    // Affiche la liste de toutes les expéditions
    @GetMapping(value = "/Expeditions")
    public List<Expedition> listeDesExpeditions(){

        List<Expedition> expeditions = expeditionDao.findAll();

        if(expeditions.isEmpty()) throw new ExpeditionNotFoundException("Aucune expedition n'est disponible !!");

        log.info("Récupération de la liste des expeditions");

        return expeditions;
    }
    //Ajouter, créer une expédition
    @PostMapping(value="/Expeditions")
    public ResponseEntity<Expedition> ajouterExpedition(@RequestBody Expedition expedition){

        Expedition expeAdded = expeditionDao.save(expedition);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(expeAdded.getId()).toUri();

        ResponseEntity<Expedition> expeAjoute = ResponseEntity.created(location).build();

        return expeAjoute;
    }

    //Récuperer une expedition par son id
    @GetMapping( value = "/Expeditions/{id}")
    public Optional<Expedition> recupererUneExpedition(@PathVariable int id) {

        Optional<Expedition> expedition = expeditionDao.findById(id);


        if(!expedition.isPresent())  throw new ExpeditionNotFoundException("L' expedition correspondant à l'id " + id + " n'existe pas");

        return expedition;
    }

    //Récuperer une expedition par son id
    @GetMapping( value = "/suivi/{idCommande}")
    public Optional<Expedition> etatExpedition(@PathVariable int idCommande) {

        Optional<Expedition> expedition = expeditionDao.findByIdCommandeLike(idCommande);


        if(!expedition.isPresent())  throw new ExpeditionNotFoundException("L' expedition correspondant à l'id " + idCommande + " n'existe pas");

        return expedition;
    }

    @PutMapping(value="/Expeditions")
    public void updateExpedition(@RequestBody Expedition expeditionUpD) {

        expeditionDao.save(expeditionUpD);
    }

    @Override
    public Health health() {
        return null;
    }
}


