package snakayima.miu.edu.dentalhospitalmgmtsystem.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import snakayima.miu.edu.dentalhospitalmgmtsystem.Domain.Patient;
import snakayima.miu.edu.dentalhospitalmgmtsystem.Service.PatientService;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;



    @PostMapping("/patients")
    public void createPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @PostMapping("/patients/appointments")
    public void addAppointment(){

    }
}
