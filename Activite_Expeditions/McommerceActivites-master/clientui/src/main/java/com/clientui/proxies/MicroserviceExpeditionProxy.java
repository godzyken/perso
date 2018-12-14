package com.clientui.proxies;

import com.clientui.beans.ExpeditionBean;
import com.clientui.beans.ProductBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "zuul-server")
@RibbonClient(name = "microservice-expedition")
public interface MicroserviceExpeditionProxy {

    /*
     * Notez ici la notation @PathVariable("id") qui est différente de celle qu'on utlise dans le contrôleur
     **/
    @GetMapping(value = "/microservice-expedition/Expeditions/{id}")
    ExpeditionBean recupererUneExpedition(@PathVariable("id") int id);


    @PutMapping(value="/microservice-expedition/Expeditions")
    ExpeditionBean updateExpedition(@RequestBody ExpeditionBean expeditionUpD);

    @PostMapping(value = "/microservice-expedition/Expeditions")
    public ResponseEntity<ExpeditionBean> ajouterExpedition(@RequestBody ExpeditionBean expedition);

    @GetMapping(value ="/microservice-expedition/suivi/{idCommande}")
    Optional<ExpeditionBean> etatExpedition(@PathVariable("idCommande") int idCommande);

}
