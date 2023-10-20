package vn.edu.iuh.fit.entity;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @Column(name = "ApptNo")
    private long apptNo;
    @Column(name = "Start")
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDateTime apptStart;
    @Column(name = "End")
    private LocalDateTime apptEnd;

    public Appointment() {
    }

    public Appointment(long apptNo) {
        this.apptNo = apptNo;
    }

    public Appointment(long apptNo, LocalDateTime apptStart, LocalDateTime apptEnd) {
        this.apptNo = apptNo;
        this.apptStart = apptStart;
        this.apptEnd = apptEnd;
    }

    public long getApptNo() {
        return apptNo;
    }

    public void setApptNo(long apptNo) {
        this.apptNo = apptNo;
    }

    public LocalDateTime getApptStart() {
        return apptStart;
    }

    public void setApptStart(LocalDateTime apptStart) {
        this.apptStart = apptStart;
    }

    public LocalDateTime getApptEnd() {
        return apptEnd;
    }

    public void setApptEnd(LocalDateTime apptEnd) {
        this.apptEnd = apptEnd;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "apptNo=" + apptNo +
                ", apptStart=" + apptStart +
                ", apptEnd=" + apptEnd +
                '}';
    }
}
