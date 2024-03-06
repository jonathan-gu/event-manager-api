package com.jg.eventmanagerapi.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="event")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	public Integer getId() {
		return this.id;
	}
	
	@Column(nullable = false)
	private String title;
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(nullable = false)
	private String description;
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(nullable = false)
	private LocalDateTime startDateTime;
	
	public LocalDateTime getStartDateTime() {
		return this.startDateTime;
	}
	
	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}
	
	@Column(nullable = false)
	private LocalDateTime endDateTime;
	
	public LocalDateTime getEndDateTime() {
		return this.endDateTime;
	}
	
	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}
	
	@Column(nullable = false)
	private String location;
	
	public String getLocation() {
		return this.location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Event(Integer id, String title, String description, LocalDateTime startDateTime, LocalDateTime endDateTime, String location) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.location = location; 
	}
	
	public Event() {
		
	}
}
