package ulbra.br.APIap2.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ulbra.br.APIap2.DTOs.GameCompanyRequestDTO;
import ulbra.br.APIap2.DTOs.GameCompanyResponseDTO;
import ulbra.br.APIap2.DTOs.GameSummaryDTO;
import ulbra.br.APIap2.exception.ResourceNotFoundException;
import ulbra.br.APIap2.model.GameCompany;
import ulbra.br.APIap2.repositories.GameCompanyRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameCompanyService {

    private final GameCompanyRepository companyRepository;

    public List<GameCompanyResponseDTO> findAll() {
        return companyRepository.findAll().stream().map(this::convertToResponseDTO).collect(Collectors.toList());
    }

    public GameCompanyResponseDTO findById(Long id) {
        GameCompany company = companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada com o id: " + id));
        return convertToResponseDTO(company);
    }

    @Transactional
    public GameCompanyResponseDTO create(GameCompanyRequestDTO requestDTO) {
        GameCompany company = new GameCompany();
        company.setName(requestDTO.name());
        company.setFoundationYear(requestDTO.foundationYear());
        company.setHeadquarters(requestDTO.headquarters());
        return convertToResponseDTO(companyRepository.save(company));
    }

    @Transactional
    public GameCompanyResponseDTO update(Long id, GameCompanyRequestDTO requestDTO) {
        GameCompany company = companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada com o id: " + id));
        company.setName(requestDTO.name());
        company.setFoundationYear(requestDTO.foundationYear());
        company.setHeadquarters(requestDTO.headquarters());
        return convertToResponseDTO(companyRepository.save(company));
    }

    @Transactional
    public void delete(Long id) {
        if (!companyRepository.existsById(id)) {
            throw new ResourceNotFoundException("Empresa não encontrada com o id: " + id);
        }
        companyRepository.deleteById(id);
    }

    private GameCompanyResponseDTO convertToResponseDTO(GameCompany company) {
        List<GameSummaryDTO> gameSummaries = company.getGames().stream()
                .map(game -> new GameSummaryDTO(game.getId(), game.getTitle()))
                .collect(Collectors.toList());
        return new GameCompanyResponseDTO(company.getId(), company.getName(), company.getFoundationYear(), company.getHeadquarters(), gameSummaries);
    }
}