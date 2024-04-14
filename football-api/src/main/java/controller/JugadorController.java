package controller;
import org.springframework.web.bind.annotation.*;
import model.Jugador;
import repository.JugadorRepository;
import java.util.List;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {
    
	public final JugadorRepository jugadorRepository;

    public JugadorController(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    @GetMapping("/{id}")
    public Jugador obtenerJugadorPorId(@PathVariable int id) {
        System.out.println("Endpoint /{id} llamado con ID: " + id);
        Jugador jugador = jugadorRepository.findById(id).orElse(null);
        System.out.println("Jugador encontrado: " + jugador);
        return jugador;
    }

    @GetMapping("/")
    public List<Jugador> obtenerTodosLosJugadores() {
        System.out.println("Endpoint / llamado");
        List<Jugador> jugadores = null;
        try {
            jugadores = jugadorRepository.findAll();
            System.out.println("Cantidad de jugadores encontrados: " + jugadores.size());
        } catch (Exception e) {
            System.out.println("Error al obtener los jugadores: " + e.getMessage());
            // Puedes realizar otras acciones aquí, como lanzar una excepción personalizada, 
            // mostrar un mensaje de error, redirigir a una página de error, etc.
        }
        return jugadores;
    }

    @PostMapping
    public Jugador crearJugador(@RequestBody Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    // Agrega otros métodos según tus necesidades
}
