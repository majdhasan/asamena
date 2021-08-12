package life.majd.asamena.service;

import life.majd.asamena.domain.Event;
import life.majd.asamena.exceptions.NoSuchEventException;
import life.majd.asamena.exceptions.NoSuchGuestException;

import java.util.List;

public interface EventService {

    Event saveEvent(Event event);

    Event getEvent(String eventId);

    Event deleteEvent(String eventId);

    List<Event> getEvents();

    void addGuestToEvent(String userId, String eventId) throws NoSuchGuestException, NoSuchEventException;

}
