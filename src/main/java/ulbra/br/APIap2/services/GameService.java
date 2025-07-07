package ulbra.br.APIap2.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ulbra.br.APIap2.DTOs.*;
import ulbra.br.APIap2.exception.ResourceNotFoundException;
import ulbra.br.APIap2.model.Game;
import ulbra.br.APIap2.model.GameCompany;
import ulbra.br.APIap2.repositories.GameCompanyRepository;
import ulbra.br.APIap2.repositories.GameRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final GameCompanyRepository companyRepository;

    public List<GameResponseDTO> findAll() {
        return gameRepository.findAll().stream().map(this::convertToResponseDTO).collect(Collectors.toList());
    }

    public GameResponseDTO findById(Long id) {
        Game game = gameRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Jogo não encontrado com o id: " + id));
        return convertToResponseDTO(game);
    }

    @Transactional
    public GameResponseDTO create(GameRequestDTO requestDTO) {
        GameCompany company = companyRepository.findById(requestDTO.companyId()).orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada com o id: " + requestDTO.companyId()));
        Game game = new Game();
        game.setTitle(requestDTO.title());
        game.setGenre(requestDTO.genre());
        game.setReleaseYear(requestDTO.releaseYear());
        game.setGameCompany(company);
        return convertToResponseDTO(gameRepository.save(game));
    }

    @Transactional
    public GameResponseDTO update(Long id, GameRequestDTO requestDTO) {
        Game game = gameRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Jogo não encontrado com o id: " + id));
        GameCompany company = companyRepository.findById(requestDTO.companyId()).orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada com o id: " + requestDTO.companyId()));
        game.setTitle(requestDTO.title());
        game.setGenre(requestDTO.genre());
        game.setReleaseYear(requestDTO.releaseYear());
        game.setGameCompany(company);
        return convertToResponseDTO(gameRepository.save(game));
    }

    @Transactional
    public void delete(Long id) {
        if (!gameRepository.existsById(id)) {
            throw new ResourceNotFoundException("Jogo não encontrado com o id: " + id);
        }
        gameRepository.deleteById(id);
    }

    private GameResponseDTO convertToResponseDTO(Game game) {
        CompanySummaryDTO companySummary = new CompanySummaryDTO(game.getGameCompany().getId(), game.getGameCompany().getName());
        return new GameResponseDTO(game.getId(), game.getTitle(), game.getGenre(), game.getReleaseYear(), companySummary);
    }
}