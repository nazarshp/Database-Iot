package com.ua.lviv.iot.lab5_back_end.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "hotel", schema = "hotel_model", catalog = "")
public class Hotel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "hotel_code")
    private String hotelCode;
    @OneToMany(mappedBy = "hotelByHotelId")
    private Collection<Location> locationsById;
    @OneToMany(mappedBy = "hotelByHotelId")
    private Collection<Review> reviewsById;
    @OneToMany(mappedBy = "hotelByHotelId")
    private Collection<Room> roomsById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHotelCode() {
        return hotelCode;
    }

    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel that = (Hotel) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(phone, that.phone) && Objects.equals(hotelCode, that.hotelCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, hotelCode);
    }

    public Collection<Location> getLocationsById() {
        return locationsById;
    }

    public void setLocationsById(Collection<Location> locationsById) {
        this.locationsById = locationsById;
    }

    public Collection<Review> getReviewsById() {
        return reviewsById;
    }

    public void setReviewsById(Collection<Review> reviewsById) {
        this.reviewsById = reviewsById;
    }

    public Collection<Room> getRoomsById() {
        return roomsById;
    }

    public void setRoomsById(Collection<Room> roomsById) {
        this.roomsById = roomsById;
    }
}
