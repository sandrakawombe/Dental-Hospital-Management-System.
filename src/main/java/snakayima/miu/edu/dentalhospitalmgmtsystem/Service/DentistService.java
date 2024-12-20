package snakayima.miu.edu.dentalhospitalmgmtsystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;
import snakayima.miu.edu.dentalhospitalmgmtsystem.Domain.Dentist;
import snakayima.miu.edu.dentalhospitalmgmtsystem.Domain.Schedule;
import snakayima.miu.edu.dentalhospitalmgmtsystem.Repository.DentistRepository;

import java.util.List;

@Service
public class DentistService {

    @Autowired
    private DentistRepository dentistRepository;


    public void createDentist(Dentist dentist) {
        dentistRepository.save(dentist);
    }

    public List<Dentist> getAllDentists() {
        return dentistRepository.findAll();
    }

    public List<Dentist> getDentistsByName(String name) {
        return dentistRepository.findDentistByWorkerId(name);
    }

    public Dentist  updateDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    public void deleteDentist(Dentist dentist) {
        dentistRepository.delete(dentist);
    }


    public List<Dentist> getAllDentistsBySchedule(List<Schedule> schedule){
        return dentistRepository.findDentistsBySchedule(schedule);
    }

    public Dentist getDentistById(Long id) {
        return dentistRepository.findById(id).orElse(null);
    }


}
