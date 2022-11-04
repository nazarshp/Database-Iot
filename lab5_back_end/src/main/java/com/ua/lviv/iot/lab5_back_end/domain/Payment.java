package com.ua.lviv.iot.lab5_back_end.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "payment", schema = "hotel_model", catalog = "")
public class Payment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "suma")
    private Double suma;
    @ManyToOne
    @JoinColumn(name = "reserved_id", referencedColumnName = "id", nullable = false)
    private Reserved reservedByReservedId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getSuma() {
        return suma;
    }

    public void setSuma(Double suma) {
        this.suma = suma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment that = (Payment) o;
        return Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(suma, that.suma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, suma);
    }

    public Reserved getReservedByReservedId() {
        return reservedByReservedId;
    }

    public void setReservedByReservedId(Reserved reservedByReservedId) {
        this.reservedByReservedId = reservedByReservedId;
    }
}
