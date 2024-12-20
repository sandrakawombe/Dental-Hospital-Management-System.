package snakayima.miu.edu.dentalhospitalmgmtsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import snakayima.miu.edu.dentalhospitalmgmtsystem.Domain.Treatment;
@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
}
