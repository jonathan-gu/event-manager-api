package com.jg.eventmanagerapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jg.eventmanagerapi.DTO.EventDTO;
import com.jg.eventmanagerapi.Entity.Event;
import com.jg.eventmanagerapi.Service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
	@Autowired
	private EventService eventService;
	
	@GetMapping()
	public ResponseEntity<List<EventDTO>> getEvents() {
		List<EventDTO> eventDTOs = eventService.getEvents();
		return new ResponseEntity<>(eventDTOs, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<EventDTO> getEvent(@Validated @RequestBody Event event) {
		if (event.getId() != null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		EventDTO eventDTO = eventService.createEvent(event);
		return new ResponseEntity<>(eventDTO, HttpStatus.CREATED);
	}
	
	@PutMapping()
	public ResponseEntity<EventDTO> updateEvent(@Validated @RequestBody Event event) {
		if (event.getId() == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		EventDTO eventDTO = eventService.updateEvent(event);
		return new ResponseEntity<>(eventDTO, HttpStatus.OK);			
	}
}
