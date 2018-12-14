package com.mexpedition.microserviceexpedition.dao;

import com.mexpedition.microserviceexpedition.model.Expedition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ExpeditionDao extends JpaRepository<Expedition, Integer> {

    public Expedition save(Expedition expedition);
    Optional<Expedition> findByIdCommandeLike(int idCommande);
}

