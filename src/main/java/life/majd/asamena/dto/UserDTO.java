package life.majd.asamena.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private String firstname;
    private String lastname;
    private String street;
    private String zip;
    private String city;
    private String country;
    private String phone;
    private String email;
}