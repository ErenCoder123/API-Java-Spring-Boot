package ulbra.br.APIap2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ulbra.br.APIap2.model.GameCompany;

@Repository
public interface GameCompanyRepository extends JpaRepository<GameCompany, Long> {
}