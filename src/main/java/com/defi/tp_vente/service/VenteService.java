package com.defi.tp_vente.service;

import com.defi.tp_vente.modele.Vente;
import com.defi.tp_vente.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenteService {
    @Autowired
    VenteRepository venteRepository;

    public void saveVente(Vente vente) {venteRepository.save(vente);
    }

    public List<Vente> showAllVente() {
        return venteRepository.findAll();}

    public Vente showOnevente(int id){
        return venteRepository.findById(id).get();
    }
    public void deleteVente(int id){venteRepository.deleteById(id);}

}
