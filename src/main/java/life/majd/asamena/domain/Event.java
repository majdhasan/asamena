package life.majd.asamena.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Event {

    @Id
    private String id;
    private String title;
    private Address address;
    private LocalDateTime eventData;
    private final Set<User> guests = new HashSet<>();
    private User organizer;
    private Boolean indoor;

}
