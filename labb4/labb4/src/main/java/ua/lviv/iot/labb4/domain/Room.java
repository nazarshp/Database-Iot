package ua.lviv.iot.labb4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Room {
    private Integer id;
    private Integer number;
    private Integer floor;
    private Integer price;
    private String type;
}
