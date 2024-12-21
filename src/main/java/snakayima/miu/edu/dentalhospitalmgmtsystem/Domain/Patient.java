package snakayima.miu.edu.dentalhospitalmgmtsystem.Domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;

import java.util.List;

@Entity
public class Patient {
    @Id
    private long id;
    private String name;
    private String patientId;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointment;

    @Version
    private int version;

    protected Patient() {}

    public Patient(String name, String patientId) {
        this.name = name;
        this.patientId = patientId;

    }

    public void addAppointment(Appointment appointment) {
        this.appointment.add(appointment);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public List<Appointment> getAppointment() {
        return appointment;
    }

    public void setAppointment(List<Appointment> appointment) {
        this.appointment = appointment;
    }
}
