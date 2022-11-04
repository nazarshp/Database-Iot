package ua.lviv.iot.labb4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client {
    private Integer id;
    private String name;
    private String surname;
    private Integer phone_number;
    private String email;
    private String birthday;
    private String gender;

}
