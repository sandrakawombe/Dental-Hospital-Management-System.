package snakayima.miu.edu.dentalhospitalmgmtsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import snakayima.miu.edu.dentalhospitalmgmtsystem.Credentials.ApplicationUser;
import snakayima.miu.edu.dentalhospitalmgmtsystem.Credentials.UserRepository;
import snakayima.miu.edu.dentalhospitalmgmtsystem.Domain.*;
import snakayima.miu.edu.dentalhospitalmgmtsystem.Repository.*;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class DentalHospitalMgmtSystemApplication implements CommandLineRunner {

    @Autowired
    private DentistRepository dentistRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private TreatmentRepository treatmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public void run(String... args) throws Exception {
        Dentist dentist = new Dentist("Sandra","D01",3);
        dentistRepository.save(dentist);

        Patient patient = new Patient("Ben","P01");
        patientRepository.save(patient);

        Treatment treatment = new Treatment("Surgery",100.00,"Root canal");
        treatmentRepository.save(treatment);

        Schedule schedule = new Schedule("Surgery","RootCanal",LocalTime.of(12,30),LocalTime.of(1,30),"Active");
        scheduleRepository.save(schedule);

        Appointment appointment = new Appointment("Dental Surgery","Root Canal",LocalDate.of(2023,12,1),LocalTime.of(12,0));
        appointmentRepository.save(appointment);

        // Add Security Users
        ApplicationUser admin = new ApplicationUser(
                "admin",
                passwordEncoder.encode("admin123"),
                "ROLE_ADMIN"
        );
        userRepository.save(admin);

        ApplicationUser user = new ApplicationUser(
                "user",
                passwordEncoder.encode("user123"),
                "ROLE_USER"
        );
        userRepository.save(user);
        System.out.println("Saving user: " + user);

    }

    public static void main(String[] args) {
        SpringApplication.run(DentalHospitalMgmtSystemApplication.class, args);
    }

}
