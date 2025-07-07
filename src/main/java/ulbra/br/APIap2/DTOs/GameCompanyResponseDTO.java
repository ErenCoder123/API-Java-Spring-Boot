package ulbra.br.APIap2.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.util.List;

public record GameCompanyResponseDTO(Long id, String name, int foundationYear, String headquarters, List<GameSummaryDTO> games) {}
public record GameCompanyRequestDTO(@NotBlank String name, @Positive int foundationYear, @NotBlank String headquarters) {}
public record GameSummaryDTO(Long id, String title) {}