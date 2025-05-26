package ulbra.br.APIap2.repositories;

import ulbra.br.APIap2.models.Jogo;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class JogoRepository {
    private List<Jogo> jogos = new ArrayList<>();
    private long currentId = 1;

    public List<Jogo> getAll() {
        return new ArrayList<>(jogos);
    }

    public Jogo getById(long id) {
        return jogos.stream()
                .filter(jogo -> jogo.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado para o ID: " + id));
    }

    public void save(Jogo jogo) {
        jogo.setId(currentId++);
        jogos.add(jogo);
    }

    public void update(long id, Jogo jogoAtualizado) {
        Jogo jogoExistente = jogos.stream()
                .filter(jogo -> jogo.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado para o ID: " + id));

        jogoExistente.setAno(jogoAtualizado.getAno());
        jogoExistente.setGenero(jogoAtualizado.getGenero());
        jogoExistente.setEstudio(jogoAtualizado.getEstudio());
    }

    public void delete(long id) {
        Jogo jogo = jogos.stream()
                .filter(j -> j.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado para o ID: " + id));

        jogos.remove(jogo);
    }
}
