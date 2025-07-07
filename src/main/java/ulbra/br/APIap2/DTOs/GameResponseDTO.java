package ulbra.br.APIap2.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record GameResponseDTO(Long id, String title, String genre, int releaseYear, CompanySummaryDTO company) {}
