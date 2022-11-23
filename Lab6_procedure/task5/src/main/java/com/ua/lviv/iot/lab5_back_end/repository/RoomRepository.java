package com.ua.lviv.iot.lab5_back_end.repository;

import com.ua.lviv.iot.lab5_back_end.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {


    @Procedure(value = "b")
    void AddMToM( int reservedId);

}
