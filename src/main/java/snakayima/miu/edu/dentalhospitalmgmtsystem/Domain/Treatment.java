package snakayima.miu.edu.dentalhospitalmgmtsystem.Domain;

import jakarta.persistence.*;

@Entity
public class Treatment {

    @Id
    @GeneratedValue
    private int id;
    private String treatmentType;
    private double cost;
    private String description;


    @ManyToOne
    @JoinColumn(name ="appointment_id")
    private Appointment appointment;

    @Version
    private int version;

    protected Treatment() {}
    public Treatment(String treatmentType, double cost, String description) {
        this.treatmentType = treatmentType;
        this.cost = cost;
        this.description = description;

    }

    public String getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(String treatmentType) {
        this.treatmentType = treatmentType;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
