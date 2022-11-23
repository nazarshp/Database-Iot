package com.ua.lviv.iot.lab5_back_end.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "room", schema = "hotel_model", catalog = "")
public class Room {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "number")
    private String number;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "floor")
    private Integer floor;
    @Basic
    @Column(name = "price")
    private Integer price;
    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id", nullable = false)
    private Hotel hotelByHotelId;
    @ManyToOne
    @JoinColumn(name = "reserved_id", referencedColumnName = "id", nullable = false)
    private Reserved reservedByReservedId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room that = (Room) o;
        return Objects.equals(id, that.id) && Objects.equals(number, that.number) && Objects.equals(type, that.type) && Objects.equals(floor, that.floor) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, type, floor, price);
    }

    public Hotel getHotelByHotelId() {
        return hotelByHotelId;
    }

    public void setHotelByHotelId(Hotel hotelByHotelId) {
        this.hotelByHotelId = hotelByHotelId;
    }

    public Reserved getReservedByReservedId() {
        return reservedByReservedId;
    }

    public void setReservedByReservedId(Reserved reservedByReservedId) {
        this.reservedByReservedId = reservedByReservedId;
    }
}
