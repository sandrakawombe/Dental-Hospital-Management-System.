package snakayima.miu.edu.dentalhospitalmgmtsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import snakayima.miu.edu.dentalhospitalmgmtsystem.Domain.Patient;

import java.util.List;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findPatientById(Long id);

    List<Patient> findPatientByName(String name);

}
