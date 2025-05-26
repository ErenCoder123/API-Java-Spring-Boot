package ulbra.br.APIap2.services;

import ulbra.br.APIap2.models.Jogo;
import ulbra.br.APIap2.repositories.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {

    private final JogoRepository jogoRepository;

    @Autowired
    public JogoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public List<Jogo> getAllJogos() {
        return jogoRepository.getAll();
    }

    public Jogo getJogoById(long id) {
        return jogoRepository.getById(id);
    }

    public void addJogo(Jogo jogo) {
        jogoRepository.save(jogo);
    }

    public void updateJogo(long id, Jogo jogoAtualizado) {
        jogoRepository.update(id, jogoAtualizado);
    }
    
    public void deleteJogo(long id) {
        jogoRepository.delete(id);
    }
}
