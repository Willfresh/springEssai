package com.defi.tp_vente.service;

import com.defi.tp_vente.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenteService {
    @Autowired
    VenteRepository venteRepository;
}
