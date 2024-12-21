package snakayima.miu.edu.dentalhospitalmgmtsystem.Service;

import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import snakayima.miu.edu.dentalhospitalmgmtsystem.Domain.Appointment;
import snakayima.miu.edu.dentalhospitalmgmtsystem.Repository.AppointmentRepository;
import snakayima.miu.edu.dentalhospitalmgmtsystem.SystemConfigurations.AppointmentSender;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentSender appointmentSender;

    public Appointment createAppointment(Appointment appointment) {
        Appointment savedAppointment = appointmentRepository.save(appointment);
        String message = "New appointment created with ID: " + savedAppointment.getId();
        appointmentSender.sendMessage(message);

        return savedAppointment;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointment(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    public Appointment updateAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    public List<Appointment> findAppointmentsByPatientAndDentist(String patientName, String dentistName) {
        return appointmentRepository.findAppointmentsByPatientAndDentist(patientName, dentistName);
    }


    public List<Appointment> findAppointmentsByCriteria(LocalDate date, String patientName, String dentistName) {
        Specification<Appointment> specification = (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
            if (date != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("date"), date));
            }
            if (patientName != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.join("patient").get("name"), patientName));
            }
            if (dentistName != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.join("dentist").get("name"), dentistName));
            }
            return predicate;
        };
        return appointmentRepository.findAll(specification);
    }
}
