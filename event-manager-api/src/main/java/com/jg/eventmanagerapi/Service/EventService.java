package com.jg.eventmanagerapi.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jg.eventmanagerapi.DTO.EventDTO;
import com.jg.eventmanagerapi.Entity.Event;
import com.jg.eventmanagerapi.Repository.EventRepository;

@Service
public class EventService {
	@Autowired
	private EventRepository eventRepository;
	
	public List<EventDTO> getEvents() {
		List<Event> events = eventRepository.findAll();
		List<EventDTO> eventDTOs = events.stream().map(EventDTO::new).collect(Collectors.toList());
		return eventDTOs;
	}
	
	public EventDTO createEvent(Event event) {
		event = eventRepository.save(event);
		return new EventDTO(event);
	}
	
	public EventDTO updateEvent(Event event) {
		event = eventRepository.save(event);
		return new EventDTO(event);
	}
}
