package life.majd.asamena.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContactDetails {

    @Id
    private String id;
    private String phone;
    private String email;
    private Address address;


}
