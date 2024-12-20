package snakayima.miu.edu.dentalhospitalmgmtsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import snakayima.miu.edu.dentalhospitalmgmtsystem.Domain.Dentist;
import snakayima.miu.edu.dentalhospitalmgmtsystem.Domain.Schedule;

import java.util.List;
@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {

    List<Dentist> findByYearsOfExperience(int yearsOfExperience);
    List<Dentist> findDentistsBySchedule(List<Schedule> schedule);
    List<Dentist> findDentistByWorkerId(String workerId);

}
