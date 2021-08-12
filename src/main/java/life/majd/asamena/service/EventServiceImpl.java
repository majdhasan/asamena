package life.majd.asamena.service;

import life.majd.asamena.domain.Event;
import life.majd.asamena.domain.User;
import life.majd.asamena.exceptions.NoSuchEventException;
import life.majd.asamena.exceptions.NoSuchGuestException;
import life.majd.asamena.repository.EventRepository;
import life.majd.asamena.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Override
    public Event saveEvent(Event event) {
        log.info("a new event with the name {} has been created and save to the database", event.getTitle());
        return eventRepository.save(event);
    }

    @Override
    public Event getEvent(String eventId) {
        Optional<Event> event = eventRepository.findById(eventId);
        return event.orElse(null);
    }

    @Override
    public Event deleteEvent(String eventId) {
        Event event = eventRepository.findById(eventId).orElse(null);
        if (event != null) {
            eventRepository.delete(event);
            log.info("event {}:{} hast been deleted", event.getId(), event.getTitle());
            return event;
        }
        log.info("event {} couldn't be found in the database", event.getId());
        return null;
    }

    @Override
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    @Override
    public void addGuestToEvent(String userId, String eventId) throws NoSuchGuestException, NoSuchEventException {
        User user = userRepository.findById(userId).orElse(null);
        Event event = eventRepository.findById(eventId).orElse(null);
        if (event == null) {
            throw new NoSuchEventException("Event could not be found in the system");
        }
        if (user == null) {
            throw new NoSuchGuestException("Guest could not be found in the system");
        }
        event.getGuests().add(user);
        eventRepository.save(event);
        log.info("{} {} has been added to event:{}", user.getFirstname(), user.getLastname(), event.getTitle());

    }
}
