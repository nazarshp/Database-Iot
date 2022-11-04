package ua.lviv.iot.labb4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hotel {
    private Integer id;
    private String name;
    private Integer phone;
    private Integer hotel_code;
}
