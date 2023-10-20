package vn.edu.iuh.fit.entity;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "service_price")
public class ServicePrice {
    @Id
    @Column(name = "ServicePriceDate")
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDateTime svcPriceDate;
    @Column(name = "Price")
    private double svcPrice;
    @Column(name = "Note", columnDefinition = "nvarchar(100)")
    private String note;
    @Id
    @ManyToOne
    @JoinColumn(name = "ServiceID")
    private Service service;

    public ServicePrice() {
    }

    public ServicePrice(double svcPrice, String note) {
        this.svcPrice = svcPrice;
        this.note = note;
    }

    public ServicePrice(LocalDateTime svcPriceDate, double svcPrice, String note, Service service) {
        this.svcPriceDate = svcPriceDate;
        this.svcPrice = svcPrice;
        this.note = note;
        this.service = service;
    }

    public LocalDateTime getSvcPriceDate() {
        return svcPriceDate;
    }

    public void setSvcPriceDate(LocalDateTime svcPriceDate) {
        this.svcPriceDate = svcPriceDate;
    }

    public double getSvcPrice() {
        return svcPrice;
    }

    public void setSvcPrice(double svcPrice) {
        this.svcPrice = svcPrice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "ServicePrice{" +
                "svcPriceDate=" + svcPriceDate +
                ", svcPrice=" + svcPrice +
                ", note='" + note + '\'' +
                ", service=" + service +
                '}';
    }
}
