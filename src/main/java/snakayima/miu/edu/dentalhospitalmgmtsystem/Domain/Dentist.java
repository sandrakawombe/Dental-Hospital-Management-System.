package snakayima.miu.edu.dentalhospitalmgmtsystem.Domain;
import jakarta.persistence.*;

import java.util.List;
@Entity
@NamedQuery(name = "Dentist.findByExperienceAndStatus",
        query = "SELECT d FROM Dentist d JOIN d.schedule s WHERE d.yearsOfExperience >= :years AND s.status = :status")

public class Dentist {
        @Id
        @GeneratedValue
        private Long id;
        private String name;
        private String workerId;
        private int yearsOfExperience;

        @OneToMany(mappedBy = "dentist")
        private List<Appointment> appointments;
        @OneToMany(mappedBy = "dentist")
        private List<Schedule> schedule;

        @Version
        private int version;
        protected Dentist() {}

    public Dentist(String name, String workerId, int yearsOfExperience) {
            this.name = name;
            this.workerId = workerId;
            this.yearsOfExperience = yearsOfExperience;

    }

    public void addAppointment(Appointment appointment) {
            this.appointments.add(appointment);
    }

    public void addSchedule(Schedule schedule) {
            this.schedule.add(schedule);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }
}
