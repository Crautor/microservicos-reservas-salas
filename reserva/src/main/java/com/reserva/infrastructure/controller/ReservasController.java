package com.reserva.infrastructure.controller;

import com.reserva.application.dto.ReservaDTO;
import com.reserva.application.service.ReservaService;
import com.reserva.domain.model.Reserva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  
@RequestMapping("/reservas")
public class ReservasController {
    @Autowired
    private ReservaService service;

    @GetMapping
    public List<Reserva> listar() {
        return service.listar();  
    }

    @GetMapping
    @RequestMapping("/completa/{reservaId}")
    public ReservaDTO getReservaCompleta(@PathVariable Long reservaId) {
        return service.getReservaCompleta(reservaId);  
    }

    @PostMapping("/salvar")
    public Reserva salvar(@RequestBody Reserva reserva) {
        return service.salvar(reserva);  
    }
}
