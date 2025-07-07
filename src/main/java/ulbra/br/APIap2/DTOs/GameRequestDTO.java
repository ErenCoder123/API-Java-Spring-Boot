package ulbra.br.APIap2.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record GameRequestDTO(@NotBlank String title, @NotBlank String genre, @Positive int releaseYear, @NotNull Long companyId) {}
