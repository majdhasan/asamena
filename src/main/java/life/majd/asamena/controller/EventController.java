package life.majd.asamena.controller;

import life.majd.asamena.domain.Event;
import life.majd.asamena.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    @GetMapping
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable("id") String id) {
        return eventService.getEvent(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addEvent(Event event) {
        eventService.saveEvent(event);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteEvent(@PathVariable("id") String id){
        eventService.deleteEvent(id);
    }

//    TODO implement editEvent in the event eventService
//    @PatchMapping("/{id}")
//    public void editEvent(Event event) {
//        eventService.
//    }


}
