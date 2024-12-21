package snakayima.miu.edu.dentalhospitalmgmtsystem.Repository;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import snakayima.miu.edu.dentalhospitalmgmtsystem.Domain.Appointment;

import java.util.List;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>, JpaSpecificationExecutor<Appointment> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<Appointment> findAllByPatientId(Long patientId);
    @Query("SELECT a FROM Appointment a JOIN a.patient p JOIN a.dentist d WHERE p.name = :patientName AND d.workerId = :workerId")
    List<Appointment> findAppointmentsByPatientAndDentist(@Param("patientName") String patientName, @Param("workerId") String workerId);


}
