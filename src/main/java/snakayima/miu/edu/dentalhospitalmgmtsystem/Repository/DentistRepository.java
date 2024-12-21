package snakayima.miu.edu.dentalhospitalmgmtsystem.Repository;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import snakayima.miu.edu.dentalhospitalmgmtsystem.Domain.Dentist;
import snakayima.miu.edu.dentalhospitalmgmtsystem.Domain.Schedule;

import java.util.List;
@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {

    List<Dentist> findByYearsOfExperience(int yearsOfExperience);
    List<Dentist> findDentistsBySchedule(List<Schedule> schedule);
    List<Dentist> findDentistByWorkerId(String workerId);
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT d FROM Dentist d WHERE d.yearsOfExperience >= :experience")
    List<Dentist> findByExperience(@Param("experience") int experience);


}
