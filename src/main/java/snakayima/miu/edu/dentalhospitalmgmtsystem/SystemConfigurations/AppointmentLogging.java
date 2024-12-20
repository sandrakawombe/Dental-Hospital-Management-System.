package snakayima.miu.edu.dentalhospitalmgmtsystem.SystemConfigurations;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import snakayima.miu.edu.dentalhospitalmgmtsystem.Domain.Appointment;

@Aspect
@Component
public class AppointmentLogging {

    @Pointcut("execution(* snakayima.miu.edu.dentalhospitalmgmtsystem.Service.AppointmentService.createAppointment(..))")
    public void createAppointmentPointcut() {
    }

    // Before advice: logs before creating an appointment
    @Before("createAppointmentPointcut() && args(appointment,..)")
    public void logBeforeCreateAppointment(Appointment appointment) {
        System.out.println("A new appointment is about to be created: " + appointment.getTitle() + " with " + appointment.getPatient().getName());
    }

    // After advice: logs after creating an appointment
    @After("createAppointmentPointcut() && args(appointment,..)")
    public void logAfterCreateAppointment(Appointment appointment) {
        System.out.println("Appointment created: " + appointment.getTitle() + " with " + appointment.getPatient().getName());
    }
}
