package com.ua.lviv.iot.lab5_back_end.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "client", schema = "hotel_model", catalog = "")
public class Client {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "birthday")
    private Date birthday;
    @Basic
    @Column(name = "gender")
    private String gender;
    @OneToMany(mappedBy = "clientByClientId")
    private Collection<Reserved> reservedsById;
    @OneToMany(mappedBy = "clientByClientId")
    private Collection<Review> reviewsById;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client that = (Client) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(email, that.email) && Objects.equals(birthday, that.birthday) && Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, phoneNumber, email, birthday, gender);
    }

    public Collection<Reserved> getReservedsById() {
        return reservedsById;
    }

    public void setReservedsById(Collection<Reserved> reservedsById) {
        this.reservedsById = reservedsById;
    }

    public Collection<Review> getReviewsById() {
        return reviewsById;
    }

    public void setReviewsById(Collection<Review> reviewsById) {
        this.reviewsById = reviewsById;
    }
}
