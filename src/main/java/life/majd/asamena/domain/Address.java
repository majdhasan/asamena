package life.majd.asamena.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {

    @Id
    private String id;
    private String street;
    private String zip;
    private String city;
    private String country;

}
