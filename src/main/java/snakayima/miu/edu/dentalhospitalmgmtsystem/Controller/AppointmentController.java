package snakayima.miu.edu.dentalhospitalmgmtsystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import snakayima.miu.edu.dentalhospitalmgmtsystem.Domain.Appointment;
import snakayima.miu.edu.dentalhospitalmgmtsystem.Service.AppointmentService;
import snakayima.miu.edu.dentalhospitalmgmtsystem.SystemConfigurations.AppointmentSender;

import java.util.List;

@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentSender appointmentSender;

    @PostMapping("/appointments")
    public void setAppointmentService(Appointment appointment) {
        appointmentService.createAppointment(appointment);

        String message ="Appointment created";
        appointmentSender.sendMessage(message);


    }

    @GetMapping("/appointment/{id}")
    public Appointment getAppointment(@PathVariable Long id) {
        return appointmentService.getAppointment(id);
    }

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }



}
