package com.jg.eventmanagerapi.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.jg.eventmanagerapi.DTO.EventDTO;
import com.jg.eventmanagerapi.Entity.Event;
import com.jg.eventmanagerapi.Repository.EventRepository;

@Service
public class EventService {
	@Autowired
	private EventRepository eventRepository;
	
	public List<EventDTO> getEvents() {
		List<Event> events = eventRepository.findByStartDateTimeGreaterThan(LocalDateTime.now());
		List<EventDTO> eventDTOs = events.stream().map(EventDTO::new).collect(Collectors.toList());
		return eventDTOs;
	}
	
	public EventDTO createEvent(Event event) {
		event = eventRepository.save(event);
		return new EventDTO(event);
	}
	
	public void updateEvent(Event event) {
		Optional<Event> oldEvent = eventRepository.findById(event.getId());
		if (!oldEvent.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		event = eventRepository.save(event);
	}
	
	public void deleteEvent(Integer id) {
		Optional<Event> oldEvent = eventRepository.findById(id);
		if (!oldEvent.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		eventRepository.deleteById(id);
	}
}
