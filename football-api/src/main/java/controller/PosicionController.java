package controller;
import org.springframework.web.bind.annotation.*;

import model.Posicion;
import repository.PosicionRepository;

import java.util.List;

@RestController
@RequestMapping("/posiciones")
public class PosicionController {
    
    private PosicionRepository posicionRepository;

    @GetMapping
    public List<Posicion> obtenerPosiciones() {
        return posicionRepository.findAll();
    }

    @PostMapping
    public Posicion crearPosicion(@RequestBody Posicion posicion) {
        return posicionRepository.save(posicion);
    }

    // Agrega otros métodos según tus necesidades
}