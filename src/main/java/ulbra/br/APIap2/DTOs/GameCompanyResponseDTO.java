package ulbra.br.APIap2.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.util.List;

public record GameCompanyResponseDTO(Long id, String name, int foundationYear, String headquarters, List<GameSummaryDTO> games) {}
