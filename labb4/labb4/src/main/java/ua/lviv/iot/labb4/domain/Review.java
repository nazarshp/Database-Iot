package ua.lviv.iot.labb4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Review {
    private Integer id;
    private Integer raiting;
    private String description;
    private String date;
}
