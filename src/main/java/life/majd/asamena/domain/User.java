package life.majd.asamena.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private ContactDetails contactDetails;
    private LocalDateTime arrivedAt;
    private LocalDateTime leftAt;

}
