package snakayima.miu.edu.dentalhospitalmgmtsystem.Domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Schedule {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private String status;
    private LocalDateTime created;

    @ManyToOne
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

    @Version
    private int version;

    protected Schedule() {}

    public Schedule(String title, String description, LocalTime startTime, LocalTime endTime, String status) {
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }
}
