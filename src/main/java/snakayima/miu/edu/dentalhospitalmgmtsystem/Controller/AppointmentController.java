package snakayima.miu.edu.dentalhospitalmgmtsystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import snakayima.miu.edu.dentalhospitalmgmtsystem.Domain.Appointment;
import snakayima.miu.edu.dentalhospitalmgmtsystem.Service.AppointmentService;
import snakayima.miu.edu.dentalhospitalmgmtsystem.SystemConfigurations.AppointmentSender;

import java.time.LocalDate;
import java.util.List;

@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentSender appointmentSender;

    @PostMapping("/appointments")
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.createAppointment(appointment);
    }

    @GetMapping("/appointments/{id}")
    public Appointment getAppointment(@PathVariable Long id) {
        return appointmentService.getAppointment(id);
    }

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/appointments/query")
    public List<Appointment> findAppointmentsByQuery(@RequestParam String patientName, @RequestParam String dentistName) {
        return appointmentService.findAppointmentsByPatientAndDentist(patientName, dentistName);
    }

    @GetMapping("/appointments/criteria")
    public List<Appointment> findAppointmentsByCriteria(@RequestParam(required = false) LocalDate date,
                                                        @RequestParam(required = false) String patientName,
                                                        @RequestParam(required = false) String dentistName) {
        return appointmentService.findAppointmentsByCriteria(date, patientName, dentistName);
    }

}
