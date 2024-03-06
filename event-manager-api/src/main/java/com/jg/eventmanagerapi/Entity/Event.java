package com.jg.eventmanagerapi.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="event")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	
	private String description;
	
	private LocalDateTime startDateTime;
	
	private LocalDateTime endDateTime;
	
	private String location;
	
	public Event(Integer id, String title, String description, LocalDateTime startDateTime, LocalDateTime endDateTime, String location) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.location = location; 
	}
	
	public Event(String title, String description, LocalDateTime startDateTime, LocalDateTime endDateTime, String location) {
		this.title = title;
		this.description = description;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.location = location; 
	}
}
