package ulbra.br.APIap2.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ulbra.br.APIap2.DTOs.GameCompanyRequestDTO;
import ulbra.br.APIap2.DTOs.GameCompanyResponseDTO;
import ulbra.br.APIap2.services.GameCompanyService;
import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class GameCompanyController {

    private final GameCompanyService companyService;

    @GetMapping
    public ResponseEntity<List<GameCompanyResponseDTO>> getAllCompanies() {
        return ResponseEntity.ok(companyService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameCompanyResponseDTO> getCompanyById(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.findById(id));
    }

    @PostMapping
    public ResponseEntity<GameCompanyResponseDTO> createCompany(@Valid @RequestBody GameCompanyRequestDTO requestDTO) {
        return new ResponseEntity<>(companyService.create(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameCompanyResponseDTO> updateCompany(@PathVariable Long id, @Valid @RequestBody GameCompanyRequestDTO requestDTO) {
        return ResponseEntity.ok(companyService.update(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        companyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}