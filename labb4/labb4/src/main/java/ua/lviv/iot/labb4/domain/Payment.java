package ua.lviv.iot.labb4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment {
    private Integer id;
    private Integer suma;
    private  String date;
}
