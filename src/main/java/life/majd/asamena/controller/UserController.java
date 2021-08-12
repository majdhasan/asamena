package life.majd.asamena.controller;

import life.majd.asamena.domain.Address;
import life.majd.asamena.domain.ContactDetails;
import life.majd.asamena.domain.User;
import life.majd.asamena.dto.UserDTO;
import life.majd.asamena.exceptions.NoSuchEventException;
import life.majd.asamena.exceptions.NoSuchGuestException;
import life.majd.asamena.service.EventService;
import life.majd.asamena.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final EventService eventService;

    @PostMapping("addToEvent/{eventId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addUserToEvent(@PathVariable("eventId") String eventId, @RequestBody UserDTO user) throws NoSuchGuestException, NoSuchEventException {
        Address address = new Address(null, user.getStreet(), user.getZip(), user.getCity(), user.getCountry());
        ContactDetails contactDetails = new ContactDetails(null, user.getPhone(), user.getEmail(), address);
        LocalDateTime now = LocalDateTime.now();
        User guest = new User(null, user.getFirstname(), user.getLastname(), contactDetails, LocalDateTime.now(), null);
        User savedUser = userService.saveUser(guest);
        eventService.addGuestToEvent(savedUser.getId(), eventId);
    }
}
