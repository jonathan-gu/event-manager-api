package com.jg.eventmanagerapi.DTO;

import java.time.LocalDateTime;

import com.jg.eventmanagerapi.Entity.Event;

public class EventDTO {
	private Integer id;
	
	public Integer getId() {
		return this.id;
	}
	
	private String title;
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	private String description;
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	private LocalDateTime startDateTime;
	
	public LocalDateTime getStartDateTime() {
		return this.startDateTime;
	}
	
	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}
	
	private LocalDateTime endDateTime;
	
	public LocalDateTime getEndDateTime() {
		return this.endDateTime;
	}
	
	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}
	
	private String location;
	
	public String getLocation() {
		return this.location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public EventDTO (Event event) {
		this.id = event.getId();
		this.title = event.getTitle();
		this.description = event.getDescription();
		this.startDateTime = event.getStartDateTime();
		this.endDateTime = event.getEndDateTime();
		this.location = event.getLocation();
	}
}
