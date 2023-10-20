package vn.edu.iuh.fit.entity;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @ManyToOne
    @JoinColumn(name = "ApptNo")
    private Appointment appointment;
    @Id
    @ManyToOne
    @JoinColumn(name = "ServiceID")
    private Service service;
    @Column(name = "IvoiceDate")
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDateTime invDate;
    @Column(name = "Price")
    private double price;
    @Column(name = "Status", columnDefinition = "tinyint(4)")
    private int status;
    @Column(name = "PaymentMethod", columnDefinition = "tinyint(4)")
    private int paymentMethod;

    public Invoice() {
    }

    public Invoice(Appointment appointment, Service service, int status, int paymentMethod) {
        this.appointment = appointment;
        this.service = service;
        this.status = status;
        this.paymentMethod = paymentMethod;
    }

    public Invoice(Appointment appointment, Service service, int paymentMethod) {
        this.appointment = appointment;
        this.service = service;
        this.paymentMethod = paymentMethod;
    }

    public Invoice(Appointment appointment, Service service, LocalDateTime invDate, double price, int status, int paymentMethod) {
        this.appointment = appointment;
        this.service = service;
        this.invDate = invDate;
        this.price = price;
        this.status = status;
        this.paymentMethod = paymentMethod;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public LocalDateTime getInvDate() {
        return invDate;
    }

    public void setInvDate(LocalDateTime invDate) {
        this.invDate = invDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "appointment=" + appointment +
                ", service=" + service +
                ", invDate=" + invDate +
                ", price=" + price +
                ", status=" + status +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}
