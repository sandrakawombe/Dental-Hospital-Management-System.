package snakayima.miu.edu.dentalhospitalmgmtsystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import snakayima.miu.edu.dentalhospitalmgmtsystem.Domain.Dentist;
import snakayima.miu.edu.dentalhospitalmgmtsystem.Service.DentistService;
import java.util.List;

@RestController
public class DentistController {

    @Autowired
    private DentistService dentistService;

    @GetMapping("/dentists")
    public List<Dentist> getAllDentists() {
        return dentistService.getAllDentists();
    }

    @GetMapping("/dentist/{name}")
    public List<Dentist> getDentistsByName(@PathVariable String name) {
        return dentistService.getDentistsByName(name);
    }

    @PostMapping("/dentist")
    public void addDentist(@RequestBody Dentist dentist) {
        dentistService.createDentist(dentist);
    }

    @GetMapping("/search")
    public List<Dentist> getExperiencedDentists(@RequestParam int yearsOfExperience) {
        return dentistService.getExperiencedAndActiveDentists(yearsOfExperience);
    }




}
