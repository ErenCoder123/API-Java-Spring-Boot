package ulbra.br.APIap2.controllers;

import ulbra.br.APIap2.models.Jogo;
import ulbra.br.APIap2.services.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    private final JogoService jogoService;

    @Autowired
    public JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }


    @GetMapping
    public List<Jogo> getAllJogos() {
        return jogoService.getAllJogos();
    }

    @GetMapping("/{id}")
    public Jogo getJogoById(@PathVariable long id) {
        return jogoService.getJogoById(id);
    }

    @PostMapping
    public void addJogo(@RequestBody Jogo jogo) {
        jogoService.addJogo(jogo);
    }

    @PutMapping("/{id}")
    public void updateJogo(@PathVariable long id, @RequestBody Jogo jogoAtualizado) {
        jogoService.updateJogo(id, jogoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deleteJogo(@PathVariable long id) {
        jogoService.deleteJogo(id);
    }
}
