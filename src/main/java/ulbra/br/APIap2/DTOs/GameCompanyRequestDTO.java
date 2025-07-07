package ulbra.br.APIap2.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record GameCompanyRequestDTO(@NotBlank String name, @Positive int foundationYear, @NotBlank String headquarters) {}
